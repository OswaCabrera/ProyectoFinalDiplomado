package unam.diplomado.cajaahorro.usuario.domain;

public class RolNotFoundException extends RuntimeException{
    public RolNotFoundException(Integer rol) {
        super("No existe el rol: " + rol);
    }
}
