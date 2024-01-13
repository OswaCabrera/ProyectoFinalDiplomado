package unam.diplomado.cajaahorro.transaccion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.diplomado.cajaahorro.transaccion.domain.Transaccion;
import unam.diplomado.cajaahorro.transaccion.domain.TransaccionPagoPrestamo;

import java.util.Optional;

public interface TransaccionPagoPrestamoRepository extends JpaRepository<TransaccionPagoPrestamo, Transaccion> {

    Optional<TransaccionPagoPrestamo> findById(Integer idTransaccion);
}
