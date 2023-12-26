package unam.diplomado.cajaahorro.usuario.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import unam.diplomado.cajaahorro.usuario.domain.EstatusCuentaNotFoundException;
import unam.diplomado.cajaahorro.usuario.domain.RolNotFoundException;
import unam.diplomado.cajaahorro.usuario.domain.UsuarioAlreadyExistsException;

@RestControllerAdvice("unam.diplomado.cajaahorroapi.usuario.api")
public class UsuarioControllerAdvice {

    @ExceptionHandler(UsuarioAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    private ErrorResponse usuarioAlreadyExistsHandler(UsuarioAlreadyExistsException ex) {
        return new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "BUSINESS_RULE",
                ex.getMessage()
        );
    }

    @ExceptionHandler(RolNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private ErrorResponse rolNotFoundHandler(RolNotFoundException ex) {
        return new ErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "DATA_INCONSISTENCY",
                ex.getMessage()
        );
    }

    @ExceptionHandler(EstatusCuentaNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private ErrorResponse estatusCuentaNotFoundHandler(EstatusCuentaNotFoundException ex) {
        return new ErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "DATA_INCONSISTENCY",
                ex.getMessage()
        );
    }

}
