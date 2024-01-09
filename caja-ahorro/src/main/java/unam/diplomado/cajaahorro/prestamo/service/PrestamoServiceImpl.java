package unam.diplomado.cajaahorro.prestamo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unam.diplomado.cajaahorro.prestamo.domain.Prestamo;
import unam.diplomado.cajaahorro.prestamo.repository.EstatusPrestamoRepository;
import unam.diplomado.cajaahorro.prestamo.repository.PrestamoRepository;
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
        prestamo.setMontoPagar(prestamo.getMontoOriginal() + (prestamo.getMontoOriginal() * prestamo.getInteres() / 100));
        prestamo.setFechaPeticion(Date.from(java.time.Instant.now()));
        System.out.println("Prestamo: " + prestamo);
        prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo buscarPrestamoPorId(Integer id) {
        return prestamoRepository.findById(id).get();
    }
}
