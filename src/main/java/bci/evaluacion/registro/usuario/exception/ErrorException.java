package bci.evaluacion.registro.usuario.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Everis
 * ErrorException.java
 */
public class ErrorException
{

    //General error status about nature of error
    private HttpStatus httpStatus;

    //General error message about nature of error
    private String message;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
