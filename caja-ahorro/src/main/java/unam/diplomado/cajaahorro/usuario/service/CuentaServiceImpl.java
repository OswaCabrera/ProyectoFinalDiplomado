package unam.diplomado.cajaahorro.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unam.diplomado.cajaahorro.usuario.domain.Cuenta;
import unam.diplomado.cajaahorro.usuario.repository.CuentaRepository;

@Service
public class CuentaServiceImpl implements CuentaService{

    @Autowired
    private CuentaRepository cuentaRepository;
    @Override
    public Cuenta altaCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta buscarCuentaPorUsuario(Integer idUsuario) {
        return cuentaRepository.findByUsuarioId(idUsuario);
    }
}
