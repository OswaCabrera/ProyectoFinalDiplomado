package unam.diplomado.cajaahorro.transaccion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import unam.diplomado.cajaahorro.prestamo.domain.EstatusPrestamo;
import unam.diplomado.cajaahorro.prestamo.domain.Prestamo;
import unam.diplomado.cajaahorro.prestamo.service.EstatusPrestamoService;
import unam.diplomado.cajaahorro.prestamo.service.HistoricoEstatusPrestamoService;
import unam.diplomado.cajaahorro.prestamo.service.PrestamoService;
import unam.diplomado.cajaahorro.transaccion.domain.Transaccion;
import unam.diplomado.cajaahorro.transaccion.domain.TransaccionPagoPrestamo;
import unam.diplomado.cajaahorro.transaccion.repository.TransaccionRepository;
import unam.diplomado.cajaahorro.usuario.domain.Cuenta;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;
import unam.diplomado.cajaahorro.usuario.service.CuentaService;

import java.util.Date;
import java.util.List;

@Service
public class TransaccionServiceImpl implements TransaccionService{

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private EstatusTransaccionService estatusTransaccionService;

    @Autowired
    private EstatusPrestamoService estatusPrestamoService;

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private HistoricoEstatusTransaccionService historicoEstatusTransaccionService;

    @Autowired
    private HistoricoEstatusPrestamoService historicoEstatusPrestamoService;

    @Autowired
    private PrestamoService prestamoService;

    @Autowired
    private TransaccionPagoPrestamoService transaccionPagoPrestamoService;

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

    @Override
    public Page<Transaccion> findAll(Pageable pageable) {
        return transaccionRepository.findAll(pageable);
    }

    @Override
    public Transaccion buscarPorId(Integer id) {
        return transaccionRepository.findById(id).get();
    }

    @Override
    public Transaccion procesarTransaccion(Transaccion transaccion, Integer decision) {
        if (decision == 1){
            historicoEstatusTransaccionService.GuardarHistoricoEstatusTransaccion(transaccion, transaccion.getEstatusTransaccionId());
            transaccion.setEstatusTransaccionId(estatusTransaccionService.buscarPorId(1));
            transaccion.setFecha(new Date());
            aumentarSaldoOPago(transaccion);
            transaccionRepository.save(transaccion);
            return transaccion;
        } else if (decision == 3) {
            historicoEstatusTransaccionService.GuardarHistoricoEstatusTransaccion(transaccion, transaccion.getEstatusTransaccionId());
            transaccion.setEstatusTransaccionId(estatusTransaccionService.buscarPorId(3));
            transaccion.setFecha(new Date());
            transaccionRepository.save(transaccion);
            return transaccion;
        }
        return transaccion;
    }


    public void aumentarSaldoOPago(Transaccion transaccion){
        if (transaccion.getTipoTransaccionId().getId() == 1){
            Cuenta cuenta = cuentaService.buscarCuentaPorUsuario(transaccion.getCuentaId().getUsuario().getId());
            cuenta.setSaldo(cuenta.getSaldo() + transaccion.getMonto());
            cuentaService.actualizar(cuenta);
        } else if (transaccion.getTipoTransaccionId().getId() == 2){
            TransaccionPagoPrestamo transaccionPagoPrestamo = transaccionPagoPrestamoService.buscarPorId(transaccion.getId());
            Prestamo prestamo = transaccionPagoPrestamo.getPrestamoId();
            historicoEstatusPrestamoService.guardarHistoricoEstatusPrestamo(prestamo, prestamo.getEstatusPrestamoId());
            prestamo.setCantidadPagada(prestamo.getCantidadPagada() + transaccion.getMonto());
            if (prestamo.getCantidadPagada().intValue() >= prestamo.getMontoPagar().intValue()){
                prestamo.setEstatusPrestamoId(estatusPrestamoService.buscarPorId(4));
            }
            prestamoService.actualizar(prestamo);
        }
    }
}
