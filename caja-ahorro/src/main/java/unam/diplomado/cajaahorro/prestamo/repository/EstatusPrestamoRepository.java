package unam.diplomado.cajaahorro.prestamo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.diplomado.cajaahorro.prestamo.domain.EstatusPrestamo;

public interface EstatusPrestamoRepository extends JpaRepository<EstatusPrestamo, Integer> {
}
