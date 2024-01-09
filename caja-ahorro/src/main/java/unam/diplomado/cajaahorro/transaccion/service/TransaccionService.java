package unam.diplomado.cajaahorro.transaccion.service;


import unam.diplomado.cajaahorro.transaccion.domain.Transaccion;
import unam.diplomado.cajaahorro.transaccion.domain.TransaccionAbonoAhorro;
import unam.diplomado.cajaahorro.usuario.domain.Cuenta;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;

import java.util.List;

public interface TransaccionService {

    List<Transaccion> buscarTransaccionesPorCuenta(Cuenta cuenta);

    Transaccion guardarTransaccion(Transaccion transaccion, Usuario usuario);

    void actualizar(Transaccion transaccion);
}
