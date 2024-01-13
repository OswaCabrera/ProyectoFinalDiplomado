package unam.diplomado.cajaahorro.prestamo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.diplomado.cajaahorro.prestamo.domain.HistoricoEstatusPrestamo;

public interface HistoricoEstatusPrestamoRepository extends JpaRepository<HistoricoEstatusPrestamo, Integer> {
}
