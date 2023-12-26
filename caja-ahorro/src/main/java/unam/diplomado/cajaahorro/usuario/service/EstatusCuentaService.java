package unam.diplomado.cajaahorro.usuario.service;

import unam.diplomado.cajaahorro.usuario.domain.EstatusCuenta;

import java.util.Optional;

public interface EstatusCuentaService {

    EstatusCuenta findEstatusCuentaById(Integer id);
}
