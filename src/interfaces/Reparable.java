package interfaces;

import fecha.Fecha;
import taller.Reparacion;

/**
 * Interface que determina las operaciones de las clases que son Reparables
 */
public interface Reparable {
    /**
     * Abre una nueva Reparaci�n para un veh�culo a la que se le pasa el motivo de la reparaci�n y la fecha
     * @param motivo Motivo de la reparaci�n
     * @param fecha fecha de la petici�n
     * @return Una nueva Reparaci�n
     */
    default Reparacion abrirReparacion(String motivo, Fecha fecha){
        return new Reparacion(this,motivo,fecha);
    }
}
