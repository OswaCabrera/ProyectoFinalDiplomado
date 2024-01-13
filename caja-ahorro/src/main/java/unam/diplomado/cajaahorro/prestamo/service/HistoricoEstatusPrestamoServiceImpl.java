package unam.diplomado.cajaahorro.prestamo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unam.diplomado.cajaahorro.prestamo.domain.EstatusPrestamo;
import unam.diplomado.cajaahorro.prestamo.domain.HistoricoEstatusPrestamo;
import unam.diplomado.cajaahorro.prestamo.domain.Prestamo;
import unam.diplomado.cajaahorro.prestamo.repository.HistoricoEstatusPrestamoRepository;

import java.util.Date;

@Service
public class HistoricoEstatusPrestamoServiceImpl implements HistoricoEstatusPrestamoService{

    @Autowired
    private HistoricoEstatusPrestamoRepository historicoEstatusPrestamoRepository;
    @Override
    public void guardarHistoricoEstatusPrestamo( Prestamo idPrestamo, EstatusPrestamo idEstatus) {
        HistoricoEstatusPrestamo historicoEstatusPrestamo = new HistoricoEstatusPrestamo();
        historicoEstatusPrestamo.setDeuda(idPrestamo.getMontoPagar());
        historicoEstatusPrestamo.setPrestamoId(idPrestamo);
        historicoEstatusPrestamo.setEstatusPrestamoId(idEstatus);
        historicoEstatusPrestamo.setFechaActualizacion(new Date());
        historicoEstatusPrestamoRepository.save(historicoEstatusPrestamo);
    }
}