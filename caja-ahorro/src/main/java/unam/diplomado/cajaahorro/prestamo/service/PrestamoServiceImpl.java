package unam.diplomado.cajaahorro.prestamo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import unam.diplomado.cajaahorro.prestamo.domain.Prestamo;
import unam.diplomado.cajaahorro.prestamo.repository.EstatusPrestamoRepository;
import unam.diplomado.cajaahorro.prestamo.repository.PrestamoRepository;
import unam.diplomado.cajaahorro.transaccion.domain.Transaccion;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;

import java.util.Date;
import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService{

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private EstatusPrestamoRepository estatusPrestamoRepository;

    @Override
    public List<Prestamo> buscarPrestamosPorUsuario(Usuario usuario) {
        return prestamoRepository.findByUsuarioId(usuario);
    }

    @Override
    public void solicitarPrestamo(Prestamo prestamo) {
        prestamo.setEstatusPrestamoId(estatusPrestamoRepository.findById(1).get());
        prestamo.setInteres(8);
        prestamo.setCantidadPagada(0);
        prestamo.setMontoPagar((int) (prestamo.getMontoOriginal() + (prestamo.getMontoOriginal() * 0.8)));
        prestamo.setFechaPeticion(Date.from(java.time.Instant.now()));
        prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo buscarPrestamoPorId(Integer id) {
        return prestamoRepository.findById(id).get();
    }

    @Override
    public Page<Prestamo> findAll(Pageable pageable) {
        return prestamoRepository.findAll(pageable);
    }

    @Override
    public void actualizarEstatus(Integer id, String decision) {
        Prestamo prestamo = prestamoRepository.findById(id).get();
        if(decision.equals("aceptar")){
            prestamo.setEstatusPrestamoId(estatusPrestamoRepository.findById(2).get());
        }else{
            prestamo.setEstatusPrestamoId(estatusPrestamoRepository.findById(3).get());
        }
        prestamoRepository.save(prestamo);
    }

    @Override
    public void actualizar(Prestamo prestamo) {
        prestamoRepository.save(prestamo);
    }


}
