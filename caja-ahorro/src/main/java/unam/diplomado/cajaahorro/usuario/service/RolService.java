package unam.diplomado.cajaahorro.usuario.service;

import unam.diplomado.cajaahorro.usuario.domain.Rol;

import java.util.Optional;

public interface RolService {

    Optional<Rol> findRolById(Integer id);
}
