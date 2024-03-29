package unam.diplomado.cajaahorro.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import unam.diplomado.cajaahorro.usuario.domain.*;
import unam.diplomado.cajaahorro.usuario.repository.CuentaRepository;
import unam.diplomado.cajaahorro.usuario.repository.EstatusCuentaRepository;
import unam.diplomado.cajaahorro.usuario.repository.RolRepository;
import unam.diplomado.cajaahorro.usuario.repository.UsuarioRepository;

import java.util.Date;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(propagation= Propagation.REQUIRED, timeout=5)
    public Usuario altaUsuario(Usuario usuario) {
        usuario.setPassword(
                passwordEncoder.encode(usuario.getPassword()));
        usuario.setRol(rolRepository.findById(2).get());
        Cuenta cuenta = new Cuenta();
        cuenta.setUsuario(usuario);
        cuenta.setSaldo(0);
        cuenta.setFechaCreacion(new Date());
        cuenta.setEstatusCuenta(estatusCuentaRepository.findById(1).get());
        usuarioRepository.save(usuario);
        cuentaRepository.save(cuenta);
        return usuario;
    }

    @Override
    public void actualizar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.get();
    }

    @Override
    public Page<Usuario> buscarTodos(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    public Long totalUsuarios() {
        return usuarioRepository.count();
    }

}
