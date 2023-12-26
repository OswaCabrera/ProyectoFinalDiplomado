package unam.diplomado.cajaahorro.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.diplomado.cajaahorro.usuario.domain.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}
