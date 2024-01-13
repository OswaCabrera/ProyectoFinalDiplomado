package unam.diplomado.cajaahorro.usuario.api;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
        model.addAttribute("usuario", usuario);
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
    public String solicitarPrestamo(Prestamo prestamo, @AuthenticationPrincipal Usuario usuario) {
        prestamo.setUsuarioId(usuario);
        prestamoService.solicitarPrestamo(prestamo);
        return "redirect:/usuario/prestamos";
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
    public String registrarAbono(@ModelAttribute("transaccion") TransaccionAbonoAhorro transaccion, @RequestParam(value = "comprobanteImagen") MultipartFile multipartFile, @AuthenticationPrincipal Usuario usuario) {
        System.out.println("Transaccion: " + transaccion);
        if(!multipartFile.isEmpty()){
            String imagenNombre= Archivos.almacenar(multipartFile,archivoRuta);
            if(imagenNombre!=null){
                transaccion.setComprobante(imagenNombre);
            }
        }
        transaccionService.guardarTransaccion(transaccion, usuario);
        return "redirect:/usuario/pagos";
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
    public String registrarPago(@ModelAttribute("transaccion") TransaccionPagoPrestamo transaccion,@RequestParam(value = "comprobanteImagen") MultipartFile multipartFile, @AuthenticationPrincipal Usuario usuario) {
        if(!multipartFile.isEmpty()){
            String imagenNombre= Archivos.almacenar(multipartFile,archivoRuta);
            if(imagenNombre!=null){
                transaccion.setComprobante(imagenNombre);
            }
        }
        Transaccion tranCreada = transaccionService.guardarTransaccion(transaccion, usuario);
        if(tranCreada.getComprobante()!=null || !tranCreada.getComprobante().isEmpty()){
            String archivo = tranCreada.getComprobante();
            String nuevoArchivo = tranCreada.getId()+"_"+archivo;
            Archivos.renombrar(archivoRuta,archivo,nuevoArchivo);
            tranCreada.setComprobante(nuevoArchivo);
            transaccionService.actualizar(tranCreada);
        }
        return "redirect:/usuario/pagos";
    }


    @PostMapping("/editar-perfil")
    public String editarPerfil(@ModelAttribute("usuarioObject") Usuario usuarioObject, @RequestParam(value = "fotografiaPerfil") MultipartFile multipartFile, @AuthenticationPrincipal Usuario usuario) {
        if(!multipartFile.isEmpty()){
            String imagenNombre= Archivos.almacenar(multipartFile,archivoRuta);
            if(imagenNombre!=null){
                usuarioObject.setFotografia(usuarioObject.getId() + "_" + imagenNombre);
                Archivos.renombrar(archivoRuta,imagenNombre,usuarioObject.getFotografia());
            }
        }
        System.out.println("Mi UsuarioObject: " + usuarioObject);
        usuarioService.actualizar(usuarioObject);
        return "redirect:/usuario/perfil";
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
