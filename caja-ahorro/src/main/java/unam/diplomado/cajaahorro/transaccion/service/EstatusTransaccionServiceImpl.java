package unam.diplomado.cajaahorro.transaccion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unam.diplomado.cajaahorro.transaccion.domain.EstatusTransaccion;
import unam.diplomado.cajaahorro.transaccion.repository.EstatusTransaccionRepository;

@Service
public class EstatusTransaccionServiceImpl implements EstatusTransaccionService{

    @Autowired
    private EstatusTransaccionRepository estatusTransaccionRepository;

    @Override
    public EstatusTransaccion buscarPorId(Integer id) {
        return estatusTransaccionRepository.findById(id).get();
    }
}
