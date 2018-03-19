package interfaces;

import fecha.Fecha;
import taller.Revision;

public interface Revisable {

    /**
     * Método para abrir una trabajo de tipo Revisión
     * @param motivo Motivo de la revisión
     * @param fecha Fecha de apertura del trabajo
     * @return Devuelve un objeto Revision
     */
    Revision abrirRevision(String motivo, Fecha fecha);

    /**
     * Establece el intervalo en Kms entre revisiones, según el tipo de vehículo
     */
    void estableceIntervaloKms();

    /**
     * Calcula los km,s para la próxima revisión periódica
     * @return Entero con los Kms de le próxima revisión
     */
    int proximaRevision();
}
