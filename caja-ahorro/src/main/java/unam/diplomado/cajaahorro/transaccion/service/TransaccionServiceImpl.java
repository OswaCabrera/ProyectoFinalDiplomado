package unam.diplomado.cajaahorro.transaccion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import unam.diplomado.cajaahorro.transaccion.domain.Transaccion;
import unam.diplomado.cajaahorro.transaccion.domain.TransaccionAbonoAhorro;
import unam.diplomado.cajaahorro.transaccion.repository.EstatusTransaccionRepository;
import unam.diplomado.cajaahorro.transaccion.repository.TransaccionRepository;
import unam.diplomado.cajaahorro.usuario.domain.Cuenta;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;
import unam.diplomado.cajaahorro.usuario.service.CuentaService;
import unam.diplomado.cajaahorro.util.Archivos;

import java.util.Date;
import java.util.List;

@Service
public class TransaccionServiceImpl implements TransaccionService{

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private EstatusTransaccionService estatusTransaccionService;

    @Autowired
    private CuentaService cuentaService;

    @Value("${ejemplo.imagen.ruta}")
    private String archivoRuta;


    @Override
    public List<Transaccion> buscarTransaccionesPorCuenta(Cuenta cuenta) {
        return transaccionRepository.findByCuentaId(cuenta);
    }

    @Override
    public Transaccion guardarTransaccion(Transaccion transaccion, Usuario usuario) {
        transaccion.setFecha(new Date());
        transaccion.setEstatusTransaccionId(estatusTransaccionService.buscarPorId(2));
        Cuenta cuenta = cuentaService.buscarCuentaPorUsuario(usuario.getId());
        transaccion.setCuentaId(cuenta);
        return transaccionRepository.save(transaccion);
    }

    @Override
    public void actualizar(Transaccion transaccion) {
        transaccionRepository.save(transaccion);
    }
}
