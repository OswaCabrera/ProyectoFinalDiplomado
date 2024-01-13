package unam.diplomado.cajaahorro.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    public String altaUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model,
                              RedirectAttributes flash) {
        if(result.hasErrors()){
            model.addAttribute("operacion","Error en los datos");
            System.out.println("Error en los datos");
            return "registro";
        }
        try {
            log.info("Alta Usuario: " + usuario);
            usuarioService.altaUsuario(usuario);
            log.info("Usuario Generado: " + usuario);
            flash.addFlashAttribute("success","Se ha registrado con éxito");
            return "redirect:/login";
        }catch (Exception e){
            ObjectError er=new ObjectError("Duplicados","Teléfono o correo ya existe");
            model.addAttribute("warning","Correo o teléfono repetido");
            result.addError(er);
        }
        return "registro";
    }

}
