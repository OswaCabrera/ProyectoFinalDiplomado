package unam.diplomado.cajaahorro.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unam.diplomado.cajaahorro.usuario.domain.EstatusCuenta;
import unam.diplomado.cajaahorro.usuario.repository.EstatusCuentaRepository;

@Service
public class EstatusCuentaServiceImpl implements EstatusCuentaService{

    @Autowired
    private EstatusCuentaRepository estatusCuentaRepository;

    @Override
    public EstatusCuenta findEstatusCuentaById(Integer id) {
        return estatusCuentaRepository.findById(id).get();
    }
}
