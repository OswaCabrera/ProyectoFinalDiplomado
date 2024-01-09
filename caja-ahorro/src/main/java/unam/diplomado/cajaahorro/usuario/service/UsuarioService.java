package unam.diplomado.cajaahorro.usuario.service;

import unam.diplomado.cajaahorro.usuario.domain.Cuenta;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;

public interface UsuarioService {
    Usuario altaUsuario(Usuario usuario);

    void actualizar(Usuario usuario);

    Usuario buscarPorId(Integer id);
}
