package unam.diplomado.cajaahorro.usuario.api;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import unam.diplomado.cajaahorro.prestamo.domain.Prestamo;
import unam.diplomado.cajaahorro.prestamo.service.PrestamoService;
import unam.diplomado.cajaahorro.transaccion.domain.Transaccion;
import unam.diplomado.cajaahorro.transaccion.domain.TransaccionAbonoAhorro;
import unam.diplomado.cajaahorro.transaccion.domain.TransaccionPagoPrestamo;
import unam.diplomado.cajaahorro.transaccion.service.TransaccionService;
import unam.diplomado.cajaahorro.usuario.domain.Cuenta;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;
import unam.diplomado.cajaahorro.usuario.service.CuentaService;
import unam.diplomado.cajaahorro.usuario.service.UsuarioService;
import unam.diplomado.cajaahorro.util.Archivos;

import java.util.List;

@Controller
@RequestMapping("usuario")
public class UsuarioController  {

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private PrestamoService prestamoService;

    @Autowired
    private TransaccionService transaccionService;

    @Autowired
    private UsuarioService usuarioService;

    @Value("${ejemplo.imagen.ruta}")
    private String archivoRuta;

    @RequestMapping("/perfil")
    public String profile(Model model,
                          @AuthenticationPrincipal Usuario usuario) {
        Usuario usuarioObject = usuarioService.buscarPorId(usuario.getId());
        model.addAttribute("usuario", usuarioObject);
        Cuenta cuenta = cuentaService.buscarCuentaPorUsuario(usuario.getId());
        model.addAttribute("cuenta", cuenta);
        return "usuario/perfil";
    }

    @RequestMapping("/prestamos")
    public String loans(Model model,
                        @AuthenticationPrincipal Usuario usuario) {
        model.addAttribute("usuario", usuario);
        List prestamos = prestamoService.buscarPrestamosPorUsuario(usuario);
        model.addAttribute("prestamos", prestamos);
        return "usuario/prestamos";
    }

    @GetMapping("/solicitar-prestamo")
    public String solicitarPrestamo(Model model,
                                    @AuthenticationPrincipal Usuario usuario) {
        model.addAttribute("usuario", usuario);
        Prestamo prestamo = new Prestamo();
        prestamo.setUsuarioId(usuario);
        model.addAttribute("prestamo", prestamo);
        return "usuario/solicitar-prestamo";
    }

    @PostMapping("/solicitar-prestamo")
    public String solicitarPrestamo(@Valid @ModelAttribute("prestamo") Prestamo prestamo,  BindingResult result, Model model,
                                    RedirectAttributes flash, @AuthenticationPrincipal Usuario usuario) {
        model.addAttribute("usuario", usuario);
        if(result.hasErrors()){
            model.addAttribute("operacion","Por favor llene todos los campos");
            System.out.println("Por favor llene todos los campos");
            return "usuario/solicitar-prestamo";
        }
        try {
            prestamo.setUsuarioId(usuario);
            prestamoService.solicitarPrestamo(prestamo);
            flash.addFlashAttribute("success","Se ha registrado con éxito el prestamo. Espere a que los administradores lo revisen");
            return "redirect:/usuario/prestamos";
        }catch (Exception e){
            ObjectError er=new ObjectError("Error","Error en la solicitud del prestamo");
            model.addAttribute("warning","Ocurrió un error al solicitar el prestamo");
            result.addError(er);
        }
        return "usuario/solicitar-prestamo";
    }

    @GetMapping("/pagos")
    public String mostrarPagos(Model model,
                                @AuthenticationPrincipal Usuario usuario) {
        model.addAttribute("usuario", usuario);
        List<Transaccion> transacciones = transaccionService.buscarTransaccionesPorCuenta(cuentaService.buscarCuentaPorUsuario(usuario.getId()));
        model.addAttribute("transacciones", transacciones);
        //System.out.println("Transacciones: " + transacciones);
        return "usuario/pagos";
    }

    @GetMapping("/registrar-abono")
    public String registrarAbono(Model model,
                                @AuthenticationPrincipal Usuario usuario) {
        model.addAttribute("usuario", usuario);
        model.addAttribute("transaccion", new TransaccionAbonoAhorro());
        return "usuario/registrar-pago";
    }

    @PostMapping("/registrar-abono")
    public String registrarAbono(@Valid @ModelAttribute("transaccion") TransaccionAbonoAhorro transaccion, BindingResult result, Model model,
                                 RedirectAttributes flash, @RequestParam(value = "comprobanteImagen") MultipartFile multipartFile, @AuthenticationPrincipal Usuario usuario) {
        model.addAttribute("usuario", usuario);
        if(result.hasErrors()){
            model.addAttribute("operacion","Por favor llene todos los campos");
            System.out.println("Por favor llene todos los campos");
            return "usuario/registrar-pago";
        }
        if(!multipartFile.isEmpty()){
            String imagenNombre= Archivos.almacenar(multipartFile,archivoRuta);
            if(imagenNombre!=null){
                transaccion.setComprobante(imagenNombre);
            }
        }
        try {
            transaccionService.guardarTransaccion(transaccion, usuario);
            flash.addFlashAttribute("success","Se ha registrado con éxito la transacción. Espere a que los administradores lo revisen");
            return "redirect:/usuario/pagos";
        }catch (Exception e){
            ObjectError er=new ObjectError("Error","Llene todos los campos");
            model.addAttribute("warning","Ocurrió un error al solicitar el prestamo");
            result.addError(er);
        }
        return "usuario/registrar-pago";
    }

    @GetMapping("/pagar-prestamo/{id}")
    public String registrarPago(@PathVariable("id") Integer id, Model model,
                                @AuthenticationPrincipal Usuario usuario){
        model.addAttribute("usuario", usuario);
        TransaccionPagoPrestamo transaccion = new TransaccionPagoPrestamo();
        transaccion.setPrestamoId(prestamoService.buscarPrestamoPorId(id));
        model.addAttribute("transaccion", transaccion);
        return "usuario/pagar-prestamo";
    }

    @PostMapping("/pagar-prestamo")
    public String registrarPago(@Valid @ModelAttribute("transaccion") TransaccionPagoPrestamo transaccion, BindingResult result, Model model,
                                RedirectAttributes flash, @RequestParam(value = "comprobanteImagen") MultipartFile multipartFile, @AuthenticationPrincipal Usuario usuario) {
        model.addAttribute("usuario", usuario);
        if(result.hasErrors()){
            model.addAttribute("operacion","Por favor llene todos los campos");
            System.out.println("Por favor llene todos los campos");
            return "usuario/pagar-prestamo";
        }
        if(!multipartFile.isEmpty()){
            String imagenNombre= Archivos.almacenar(multipartFile,archivoRuta);
            if(imagenNombre!=null){
                transaccion.setComprobante(imagenNombre);
            }
        }
        try {
            Transaccion tranCreada = transaccionService.guardarTransaccion(transaccion, usuario);
            if (tranCreada.getComprobante() != null || !tranCreada.getComprobante().isEmpty()) {
                String archivo = tranCreada.getComprobante();
                String nuevoArchivo = tranCreada.getId() + "_" + archivo;
                Archivos.renombrar(archivoRuta, archivo, nuevoArchivo);
                tranCreada.setComprobante(nuevoArchivo);
                transaccionService.actualizar(tranCreada);
                flash.addFlashAttribute("success","Se ha registrado con éxito la transacción. Espere a que los administradores lo revisen");
                return "redirect:/usuario/pagos";
            }
        }catch (Exception e){
            ObjectError er=new ObjectError("Error","Llene todos los campos");
            model.addAttribute("warning","Ocurrió un error al solicitar el prestamo");
            result.addError(er);
        }
        return "usuario/pagar-prestamo";
    }


    @PostMapping("/editar-perfil")
    public String editarPerfil(@Valid @ModelAttribute("usuarioObject") Usuario usuarioObject,
                               @RequestParam(value = "fotografiaPerfil") MultipartFile multipartFile,
                               @AuthenticationPrincipal Usuario usuario, BindingResult result, Model model,
                               RedirectAttributes flash) {
        if(!multipartFile.isEmpty()){
            String imagenNombre= Archivos.almacenar(multipartFile,archivoRuta);
            if(imagenNombre!=null){
                usuarioObject.setFotografia(usuarioObject.getId() + "_" + imagenNombre);
                Archivos.renombrar(archivoRuta,imagenNombre,usuarioObject.getFotografia());
            }
        }
        try {
            usuarioService.actualizar(usuarioObject);
            flash.addFlashAttribute("success","Tus datos se han actualizado con éxito. Vuelve a iniciar sesión para ver los cambios");
            return "redirect:/usuario/perfil";
        }catch (Exception e){
            ObjectError er=new ObjectError("Duplicados","Teléfono o correo ya existe");
            model.addAttribute("warning","Correo o teléfono repetido");
            result.addError(er);
        }
        return "usuario/editar-perfil";
    }

    @GetMapping("/editar-perfil")
    public String editarPerfil(Model model,
                               @AuthenticationPrincipal Usuario usuario) {
        Usuario usuarioObject = usuarioService.buscarPorId(usuario.getId());
        model.addAttribute("usuarioObject", usuarioObject);
        model.addAttribute("usuario", usuario);
        return "usuario/editar-perfil";
    }
}
