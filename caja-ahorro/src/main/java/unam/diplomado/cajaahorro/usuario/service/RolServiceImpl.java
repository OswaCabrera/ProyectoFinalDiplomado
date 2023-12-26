package unam.diplomado.cajaahorro.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unam.diplomado.cajaahorro.usuario.domain.Rol;
import unam.diplomado.cajaahorro.usuario.repository.RolRepository;

import java.util.Optional;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Optional<Rol> findRolById(Integer id) {
        return rolRepository.findById(id);
    }
}
