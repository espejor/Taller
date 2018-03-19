package interfaces;

import fecha.Fecha;
import taller.Reparacion;

/**
 * Interface que determina las operaciones de las clases que son Reparables
 */
public interface Reparable {
    /**
     * Abre una nueva Reparación para un vehículo a la que se le pasa el motivo de la reparación y la fecha
     * @param motivo Motivo de la reparación
     * @param fecha fecha de la petición
     * @return Una nueva Reparación
     */
    default Reparacion abrirReparacion(String motivo, Fecha fecha){
        return new Reparacion(this,motivo,fecha);
    }
}
