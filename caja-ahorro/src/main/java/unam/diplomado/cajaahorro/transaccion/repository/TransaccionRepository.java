package unam.diplomado.cajaahorro.transaccion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.diplomado.cajaahorro.transaccion.domain.Transaccion;
import unam.diplomado.cajaahorro.usuario.domain.Cuenta;

import java.util.List;

public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {

    List<Transaccion> findByCuentaId(Cuenta cuentaId);

}
