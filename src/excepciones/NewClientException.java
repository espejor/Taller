package excepciones;


/**
 * Excepci�n que se genera cuando se intenta agregar un cliente a la lista de clientes y �ste ya existe
 */
public class NewClientException extends RuntimeException{
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public NewClientException(String message) {
        super(message);
    }
}
