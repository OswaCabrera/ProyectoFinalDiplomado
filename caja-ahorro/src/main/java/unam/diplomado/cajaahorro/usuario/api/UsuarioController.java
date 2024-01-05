package unam.diplomado.cajaahorro.usuario.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import unam.diplomado.cajaahorro.prestamo.domain.Prestamo;
import unam.diplomado.cajaahorro.prestamo.service.PrestamoService;
import unam.diplomado.cajaahorro.usuario.domain.Cuenta;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;
import unam.diplomado.cajaahorro.usuario.service.CuentaService;
import unam.diplomado.cajaahorro.usuario.service.UsuarioService;

import java.util.List;

@Controller
@RequestMapping("usuario")
public class UsuarioController  {

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private PrestamoService prestamoService;

    //A route to show the user's profile
    @RequestMapping("/perfil")
    public String profile(Model model,
                          @AuthenticationPrincipal Usuario usuario) {
        model.addAttribute("usuario", usuario);
        Cuenta cuenta = cuentaService.buscarCuentaPorUsuario(usuario.getId());
        model.addAttribute("cuenta", cuenta);
        System.out.println("Cuenta: " + cuenta);
        System.out.println("Usuario: " + usuario);
        return "usuario/perfil";
    }

    // A route to show the list of the user's loans
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
        System.out.println("Prestamo: " + prestamo);
        prestamo.setUsuarioId(usuario);
        prestamoService.solicitarPrestamo(prestamo);
        return "redirect:/usuario/prestamos";
    }

    @GetMapping("/pagos")
    public String registrarPago(Model model,
                                @AuthenticationPrincipal Usuario usuario) {
        model.addAttribute("usuario", usuario);
        return "usuario/pagos";
    }
}
