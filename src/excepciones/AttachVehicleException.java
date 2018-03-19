package excepciones;

/**
 * Excepción que se genera cuando se intenta agregar un vehículo a la lista de vehículos y éste ya existe
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
