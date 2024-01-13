package unam.diplomado.cajaahorro.transaccion.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unam.diplomado.cajaahorro.transaccion.domain.Transaccion;
import unam.diplomado.cajaahorro.transaccion.service.TransaccionService;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;
import unam.diplomado.cajaahorro.util.RenderPagina;

@Controller
@RequestMapping("transaccion")
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    @GetMapping("lista-transacciones")
    public String listarTransacciones(@RequestParam(name = "page", defaultValue = "0") int page, Model model, @AuthenticationPrincipal Usuario usuario){
        Pageable pagReq = org.springframework.data.domain.PageRequest.of(page, 10);
        Page<Transaccion> transacciones = transaccionService.findAll(pagReq);
        RenderPagina<Transaccion> render = new RenderPagina<>("lista-transacciones", transacciones);
        model.addAttribute("transacciones", transacciones);
        model.addAttribute("page", render);
        model.addAttribute("usuario", usuario);
        return "transaccion/listar-transacciones";
    }

    @GetMapping("revisar-transaccion/{id}")
    public String revisarTransaccion(@PathVariable("id") Integer id, Model model, @AuthenticationPrincipal Usuario usuario){
        Transaccion transaccion = transaccionService.buscarPorId(id);
        model.addAttribute("transaccion", transaccion);
        model.addAttribute("usuario", usuario);
        return "transaccion/revisar-transaccion";
    }

    @PostMapping("procesar-transaccion")
    public String procesarTransaccion(@ModelAttribute("transaccion") Transaccion transaccion, @RequestParam("decision") Integer decision,Model model, @AuthenticationPrincipal Usuario usuario){
        Transaccion transaccionActual = transaccionService.buscarPorId(transaccion.getId());
        Transaccion transaccionGuardada = transaccionService.procesarTransaccion(transaccionActual, decision);
        model.addAttribute("usuario", usuario);
        model.addAttribute("transaccion", transaccionGuardada);
        return "transaccion/revisar-transaccion";
    }
}
