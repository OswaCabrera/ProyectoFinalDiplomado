package unam.diplomado.cajaahorro.prestamo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.diplomado.cajaahorro.prestamo.domain.Prestamo;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

    List<Prestamo> findByUsuarioId(Usuario usuario);
}
