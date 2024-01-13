package unam.diplomado.cajaahorro.transaccion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.diplomado.cajaahorro.transaccion.domain.HistoricoEstatusTransaccion;

public interface HistoricoEstatusTransaccionRepository extends JpaRepository<HistoricoEstatusTransaccion, Integer> {

}
