package unam.diplomado.cajaahorro.transaccion.service;

import unam.diplomado.cajaahorro.transaccion.domain.TransaccionPagoPrestamo;

public interface TransaccionPagoPrestamoService {
    TransaccionPagoPrestamo buscarPorId(Integer idTransaccion);
}
