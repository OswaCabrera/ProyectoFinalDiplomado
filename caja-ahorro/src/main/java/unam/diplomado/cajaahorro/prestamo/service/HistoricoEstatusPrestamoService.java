package unam.diplomado.cajaahorro.prestamo.service;

import unam.diplomado.cajaahorro.prestamo.domain.EstatusPrestamo;
import unam.diplomado.cajaahorro.prestamo.domain.Prestamo;

public interface HistoricoEstatusPrestamoService {
   void guardarHistoricoEstatusPrestamo(Prestamo idPrestamo, EstatusPrestamo idEstatus);
}
