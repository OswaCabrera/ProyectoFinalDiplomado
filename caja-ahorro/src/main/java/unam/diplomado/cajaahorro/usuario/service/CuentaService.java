package unam.diplomado.cajaahorro.usuario.service;

import unam.diplomado.cajaahorro.usuario.domain.Cuenta;

public interface CuentaService {

    Cuenta altaCuenta(Cuenta cuenta);

    Cuenta buscarCuentaPorUsuario(Integer idUsuario);

    Cuenta actualizar(Cuenta cuenta);

    Long getDineroAhorrado();
}
