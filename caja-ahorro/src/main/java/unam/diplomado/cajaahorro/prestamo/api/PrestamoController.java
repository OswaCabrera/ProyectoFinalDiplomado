package unam.diplomado.cajaahorro.prestamo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unam.diplomado.cajaahorro.prestamo.domain.Prestamo;
import unam.diplomado.cajaahorro.prestamo.service.PrestamoService;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;
import unam.diplomado.cajaahorro.util.RenderPagina;

@Controller
@RequestMapping("prestamo")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping("lista-prestamos")
    public String listarPrestamos(@RequestParam(name = "page", defaultValue = "0") int page, Model model, @AuthenticationPrincipal Usuario usuario){
        Pageable pagReq = PageRequest.of(page, 10);
        Page<Prestamo> prestamos = prestamoService.findAll(pagReq);
        RenderPagina<Prestamo> render = new RenderPagina<>("lista-prestamos", prestamos);
        model.addAttribute("prestamos", prestamos);
        model.addAttribute("page", render);
        model.addAttribute("usuario", usuario);
        return "prestamo/listar-prestamos";
    }

    @GetMapping("revisar-prestamo/{id}")
    public String verPrestamo(@PathVariable("id") Integer id, Model model, @AuthenticationPrincipal Usuario usuario){
        Prestamo prestamo = prestamoService.buscarPrestamoPorId(id);
        model.addAttribute("prestamo", prestamo);
        model.addAttribute("usuario", usuario);
        return "prestamo/ver-prestamo";
    }

    @PostMapping("/actualizar-prestamo-estatus")
    public String actualizarPrestamo(@ModelAttribute("prestamo") Prestamo prestamoId, @RequestParam("decision") String decision,Model model, @AuthenticationPrincipal Usuario usuario){
        prestamoService.actualizarEstatus(prestamoId.getId(), decision);
        model.addAttribute("usuario", usuario);
        Prestamo prestamo = prestamoService.buscarPrestamoPorId(prestamoId.getId());
        model.addAttribute("prestamo", prestamo);
        return "prestamo/ver-prestamo";
    }
}
