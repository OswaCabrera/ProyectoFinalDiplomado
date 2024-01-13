package unam.diplomado.cajaahorro.usuario.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import unam.diplomado.cajaahorro.usuario.domain.Cuenta;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;

public interface UsuarioService {
    Usuario altaUsuario(Usuario usuario);

    void actualizar(Usuario usuario);

    Usuario buscarPorId(Integer id);

    Page<Usuario> buscarTodos(Pageable pageable);
}
