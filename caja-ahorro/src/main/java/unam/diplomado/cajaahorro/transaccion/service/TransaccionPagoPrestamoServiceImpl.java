package unam.diplomado.cajaahorro.transaccion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unam.diplomado.cajaahorro.transaccion.domain.TransaccionPagoPrestamo;
import unam.diplomado.cajaahorro.transaccion.repository.TransaccionPagoPrestamoRepository;

@Service
public class TransaccionPagoPrestamoServiceImpl implements TransaccionPagoPrestamoService {

    @Autowired
    private TransaccionPagoPrestamoRepository transaccionPagoPrestamoRepository;
    @Override
    public TransaccionPagoPrestamo buscarPorId(Integer idTransaccion) {
        return transaccionPagoPrestamoRepository.findById(idTransaccion).orElse(null);
    }
}
