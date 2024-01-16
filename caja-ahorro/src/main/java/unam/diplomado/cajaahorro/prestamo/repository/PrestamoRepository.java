package unam.diplomado.cajaahorro.prestamo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import unam.diplomado.cajaahorro.prestamo.domain.EstatusPrestamo;
import unam.diplomado.cajaahorro.prestamo.domain.Prestamo;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

    List<Prestamo> findByUsuarioId(Usuario usuario);

    Long countByEstatusPrestamoId(EstatusPrestamo estatusPrestamo);

    //A query that sum all montoOriginal from Prestamo
    @Query("SELECT SUM(p.montoOriginal) FROM Prestamo p where p.estatusPrestamoId = ?1")
    Long sumMontoOriginalByEstatusPrestamoId(EstatusPrestamo estatusPrestamo);


}
