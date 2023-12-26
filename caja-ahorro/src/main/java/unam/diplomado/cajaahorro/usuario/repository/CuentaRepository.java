package unam.diplomado.cajaahorro.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.diplomado.cajaahorro.usuario.domain.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
}
