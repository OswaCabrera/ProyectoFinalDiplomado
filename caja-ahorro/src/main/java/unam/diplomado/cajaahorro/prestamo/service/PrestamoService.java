package unam.diplomado.cajaahorro.prestamo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import unam.diplomado.cajaahorro.prestamo.domain.Prestamo;
import unam.diplomado.cajaahorro.transaccion.domain.Transaccion;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;

import java.util.List;

public interface PrestamoService {

    List<Prestamo> buscarPrestamosPorUsuario(Usuario usuario);

    void solicitarPrestamo(Prestamo prestamo);

    Prestamo buscarPrestamoPorId(Integer id);

    Page<Prestamo> findAll(Pageable pageable);

    void actualizarEstatus(Integer prestamo, String decision);

    void actualizar(Prestamo prestamo);

}
