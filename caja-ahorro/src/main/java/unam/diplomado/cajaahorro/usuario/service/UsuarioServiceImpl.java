package unam.diplomado.cajaahorro.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import unam.diplomado.cajaahorro.usuario.domain.*;
import unam.diplomado.cajaahorro.usuario.repository.CuentaRepository;
import unam.diplomado.cajaahorro.usuario.repository.EstatusCuentaRepository;
import unam.diplomado.cajaahorro.usuario.repository.RolRepository;
import unam.diplomado.cajaahorro.usuario.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private EstatusCuentaRepository estatusCuentaRepository;

    @Override
    public Usuario altaUsuario(Usuario usuario) {
        return null;
    }

    /*
    @Override
    @Transactional(propagation= Propagation.REQUIRED, timeout=5)
    public Usuario registrarUsuario(Usuario usuario, Cuenta cuenta) {
        Optional<Usuario> usuarioExistente =
                usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new UsuarioAlreadyExistsException(usuario.getEmail());
        }
        Optional<Rol> rolExistente =
                rolRepository.findById(usuario.getRol().getId());
        if (rolExistente.isEmpty()) {
            throw new RolNotFoundException(usuario.getRol().getId());
        }
        Optional<EstatusCuenta> estatusCuentaExistente =
                estatusCuentaRepository.findById(cuenta.getEstatusCuenta().getId());
        if (estatusCuentaExistente.isEmpty()) {
            throw new EstatusCuentaNotFoundException(cuenta.getEstatusCuenta().getId());
        }
        usuario.setRol(rolExistente.get());
        usuarioRepository.save(usuario);
        cuenta.setEstatusCuenta(estatusCuentaExistente.get());
        cuenta.setUsuario(usuario);
        cuentaRepository.save(cuenta);
        return usuario;
    }

     */
}
