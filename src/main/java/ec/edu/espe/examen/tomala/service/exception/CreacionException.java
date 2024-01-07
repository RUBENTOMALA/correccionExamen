package ec.edu.espe.examen.tomala.service.exception;

public class CreacionException extends RuntimeException {

    public CreacionException(String message){
        super(message);
    }

    public CreacionException(String message, Exception cause){
        super(message, cause);
    }

}
