package excepciones;

/**
 * Excepci�n que se genera cuando se intenta agregar un veh�culo a la lista de veh�culos y �ste ya existe
 */
public class AttachVehicleException extends RuntimeException {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public AttachVehicleException(String message) {
        super(message);
    }
}
