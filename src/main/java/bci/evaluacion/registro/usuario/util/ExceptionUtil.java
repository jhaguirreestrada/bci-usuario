package bci.evaluacion.registro.usuario.util;

import java.util.ArrayList;
import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;

import bci.evaluacion.registro.usuario.exception.ErrorException;
import bci.evaluacion.registro.usuario.exception.ErrorResponse;
import javassist.NotFoundException;


/**
 * @author Everis
 * ExceptionUtil.java
 */
public class ExceptionUtil {

    /*
     * Metodo que genera el Response de Error para las peticiones de servicios
     * @param ex     Exception para ser mapeada en el responde
     * @return ErrorResponse
     */
    public static ErrorResponse getResponse(Exception ex, String mensaje) {
        List<String> details = new ArrayList<>();
        details.add(ex.toString());
        ErrorException errorExcepcion = getExcepcion(ex, mensaje);
        ErrorResponse errorResponse = new ErrorResponse( errorExcepcion.getMessage());
        return errorResponse;
    }

    /*
     * Metodo que genera el Exception de Error para las peticiones de servicios
     * @param ex     Exception para ser mapeada en el responde
     * @return ErrorException
     */
    public static ErrorException getExcepcion(Exception ex, String mensaje) {
        ErrorException errorEx = new ErrorException();

        if (ex instanceof AuthenticationException) {
            errorEx.setHttpStatus(HttpStatus.UNAUTHORIZED);
            errorEx.setMessage("Error de autorización(seguridad) en la ejecución del servicio");
        }else if (ex instanceof NotFoundException) {
            errorEx.setHttpStatus(HttpStatus.NOT_FOUND);
            errorEx.setMessage("Destino o recurso invocado no existe");
        }else{
            if (mensaje != null) {
                mensaje = "[" + mensaje + " - " + ex.getMessage() + "]";
            }else{
                mensaje = "[" + ex.getMessage() + "]";
            }
            errorEx.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            errorEx.setMessage("Error en la ejecucion del servicio - " + mensaje);
        }

        return errorEx;
    }
}