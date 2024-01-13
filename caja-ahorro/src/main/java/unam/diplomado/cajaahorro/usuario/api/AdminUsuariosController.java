package unam.diplomado.cajaahorro.usuario.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import unam.diplomado.cajaahorro.usuario.domain.Cuenta;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;
import unam.diplomado.cajaahorro.usuario.service.CuentaService;
import unam.diplomado.cajaahorro.usuario.service.UsuarioService;
import unam.diplomado.cajaahorro.util.RenderPagina;

@Controller
@RequestMapping("admin")
public class AdminUsuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("lista-usuarios")
    public String listarUsuarios(@RequestParam(name = "page", defaultValue = "0") int page , Model model,
                                 @AuthenticationPrincipal Usuario usuario){
        model.addAttribute("usuario", usuario);
        Pageable pagReq = org.springframework.data.domain.PageRequest.of(page, 10);
        Page<Usuario> usuarios = usuarioService.buscarTodos(pagReq);
        RenderPagina<Usuario> render = new RenderPagina<>("lista-usuarios", usuarios);
        model.addAttribute("usuarios", usuarios);
        return "admin/lista-usuarios";
    }

    @GetMapping("perfil-usuario/{id}")
    public String verPerfilUsuario(@PathVariable(name = "id") Integer id, Model model,
                                   @AuthenticationPrincipal Usuario usuario){
        model.addAttribute("usuario", usuario);
        Usuario usuarioPerfil = usuarioService.buscarPorId(id);
        Cuenta cuenta=  cuentaService.buscarCuentaPorUsuario(usuarioPerfil.getId());
        model.addAttribute("usuarioPerfil", usuarioPerfil);
        model.addAttribute("cuenta", cuenta);
        return "admin/perfil-usuario";
    }
}
