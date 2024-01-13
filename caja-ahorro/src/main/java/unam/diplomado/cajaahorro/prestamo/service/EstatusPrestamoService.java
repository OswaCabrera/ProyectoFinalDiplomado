package unam.diplomado.cajaahorro.prestamo.service;

import unam.diplomado.cajaahorro.prestamo.domain.EstatusPrestamo;

public interface EstatusPrestamoService {
    EstatusPrestamo buscarPorId(Integer idEstatus);
}
