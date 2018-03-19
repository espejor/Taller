package taller;

/**
 * Enumerado de los estados en que puede estar un Trabajo
 */
public enum Estado {
    ESPERA("El veh�culo est� ingresado a la espera de iniciar los trabajos"),
    ABIERTA("Se ha abierto la OT por parte del mec�nico"),
    CERRADA("La OT se ha cerrado");

    /**
     * Constructor parametrizado
     * @param descripcion Descripci�n del Estado
     */
    Estado(String descripcion){
        this.descripcion = descripcion;
    }

    /**
     * Descripci�n del par�metro
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
