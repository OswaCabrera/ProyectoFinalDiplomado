package unam.diplomado.cajaahorro.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;
import unam.diplomado.cajaahorro.usuario.service.UsuarioService;

@Slf4j
@Controller
@RequestMapping("/registro")
public class AltaUsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String init(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping
    public String altaUsuario(Usuario usuario) {
        log.info("Alta Usuario: " + usuario);
        usuarioService.altaUsuario(usuario);
        log.info("Usuario Generado: " + usuario);
        return "redirect:/login";
    }

}
