package unam.diplomado.cajaahorro.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.diplomado.cajaahorro.usuario.domain.EstatusCuenta;

public interface EstatusCuentaRepository extends JpaRepository<EstatusCuenta, Integer> {
}
