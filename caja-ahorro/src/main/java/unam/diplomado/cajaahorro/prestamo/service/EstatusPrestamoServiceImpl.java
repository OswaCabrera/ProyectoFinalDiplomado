package unam.diplomado.cajaahorro.prestamo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unam.diplomado.cajaahorro.prestamo.domain.EstatusPrestamo;
import unam.diplomado.cajaahorro.prestamo.repository.EstatusPrestamoRepository;

@Service
public class EstatusPrestamoServiceImpl implements EstatusPrestamoService{

    @Autowired
    private EstatusPrestamoRepository estatusPrestamoRepository;

    @Override
    public EstatusPrestamo buscarPorId(Integer idEstatus) {
        return estatusPrestamoRepository.findById(idEstatus).get();
    }
}
