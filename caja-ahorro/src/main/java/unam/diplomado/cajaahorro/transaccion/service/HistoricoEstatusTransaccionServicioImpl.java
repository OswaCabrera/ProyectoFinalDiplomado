package unam.diplomado.cajaahorro.transaccion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unam.diplomado.cajaahorro.transaccion.domain.EstatusTransaccion;
import unam.diplomado.cajaahorro.transaccion.domain.HistoricoEstatusTransaccion;
import unam.diplomado.cajaahorro.transaccion.domain.Transaccion;
import unam.diplomado.cajaahorro.transaccion.repository.HistoricoEstatusTransaccionRepository;

import java.util.Date;

@Service
public class HistoricoEstatusTransaccionServicioImpl implements HistoricoEstatusTransaccionService{

    @Autowired
    private HistoricoEstatusTransaccionRepository historicoEstatusTransaccionRepository;

    @Override
    public void GuardarHistoricoEstatusTransaccion(Transaccion transaccion, EstatusTransaccion estatusTransaccion) {
        HistoricoEstatusTransaccion historicoEstatusTransaccion = new HistoricoEstatusTransaccion();
        historicoEstatusTransaccion.setTransaccionId(transaccion);
        historicoEstatusTransaccion.setEstatusTransaccionId(estatusTransaccion);
        historicoEstatusTransaccion.setFecha(Date.from(new Date().toInstant()));
        historicoEstatusTransaccionRepository.save(historicoEstatusTransaccion);
    }
}
