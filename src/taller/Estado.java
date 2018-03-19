package taller;

/**
 * Enumerado de los estados en que puede estar un Trabajo
 */
public enum Estado {
    ESPERA("El vehículo está ingresado a la espera de iniciar los trabajos"),
    ABIERTA("Se ha abierto la OT por parte del mecánico"),
    CERRADA("La OT se ha cerrado");

    /**
     * Constructor parametrizado
     * @param descripcion Descripción del Estado
     */
    Estado(String descripcion){
        this.descripcion = descripcion;
    }

    /**
     * Descripción del parámetro
     */
    String descripcion;

    /**
     * Getter de descripcion
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }
}
