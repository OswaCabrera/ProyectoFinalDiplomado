package unam.diplomado.cajaahorro.transaccion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.diplomado.cajaahorro.transaccion.domain.EstatusTransaccion;

public interface EstatusTransaccionRepository extends JpaRepository<EstatusTransaccion, Integer> {
}
