package unam.diplomado.cajaahorro.transaccion.service;

import unam.diplomado.cajaahorro.transaccion.domain.EstatusTransaccion;
import unam.diplomado.cajaahorro.transaccion.domain.Transaccion;

public interface HistoricoEstatusTransaccionService {

    void GuardarHistoricoEstatusTransaccion(Transaccion transaccion, EstatusTransaccion estatusTransaccion);
}
