package interfaces;

import fecha.Fecha;
import taller.Revision;

public interface Revisable {

    /**
     * M�todo para abrir una trabajo de tipo Revisi�n
     * @param motivo Motivo de la revisi�n
     * @param fecha Fecha de apertura del trabajo
     * @return Devuelve un objeto Revision
     */
    Revision abrirRevision(String motivo, Fecha fecha);

    /**
     * Establece el intervalo en Kms entre revisiones, seg�n el tipo de veh�culo
     */
    void estableceIntervaloKms();

    /**
     * Calcula los km,s para la pr�xima revisi�n peri�dica
     * @return Entero con los Kms de le pr�xima revisi�n
     */
    int proximaRevision();
}
