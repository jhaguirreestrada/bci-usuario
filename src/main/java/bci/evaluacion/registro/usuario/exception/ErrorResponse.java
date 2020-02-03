package bci.evaluacion.registro.usuario.exception;

/**
 * @author Everis
 * ErrorResponse.java
 */
public class ErrorResponse
{
	//General error message about nature of error
    private String mensaje;
    
    
    public ErrorResponse() {
        super();
    }

    public ErrorResponse(String message) {
        super();
        this.mensaje = message;
    }

    public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


    
}
