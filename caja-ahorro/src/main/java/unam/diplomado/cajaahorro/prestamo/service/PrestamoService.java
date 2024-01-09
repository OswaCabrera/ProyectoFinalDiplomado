package unam.diplomado.cajaahorro.prestamo.service;

import unam.diplomado.cajaahorro.prestamo.domain.Prestamo;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;

import java.util.List;

public interface PrestamoService {

    List<Prestamo> buscarPrestamosPorUsuario(Usuario usuario);

    void solicitarPrestamo(Prestamo prestamo);

    Prestamo buscarPrestamoPorId(Integer id);
}
