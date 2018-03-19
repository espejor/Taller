package excepciones;

/**
 * Excepción que se genera cuando se intenta contratar a un empleado y éste ya existe
 */
public class HirePersonException extends RuntimeException {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public HirePersonException(String message) {
        super(message);
    }
}
