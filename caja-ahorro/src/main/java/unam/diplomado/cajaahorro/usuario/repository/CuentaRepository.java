package unam.diplomado.cajaahorro.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import unam.diplomado.cajaahorro.usuario.domain.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    Cuenta findByUsuarioId(Integer idUsuario);

    @Query("SELECT SUM(c.saldo) FROM Cuenta c")
    Long sumSaldo();
}
