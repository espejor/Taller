package taller;

import documentacion.EtiquetaCambioAceite;
import eventos.EventWorkShop;
import fecha.Fecha;
import interfaces.Revisable;
import vehiculos.Vehiculo;

/**
 * Clase concreta de un tipo de trabajo que modela una Revisión
 */
public class Revision extends Trabajo {
    public Revision(Revisable vehiculo, String motivo, Fecha fechaIngreso) {
        super((Vehiculo) vehiculo, motivo, fechaIngreso);
    }

    @Override
    public void onCloseOT(EventWorkShop e) {
        if (getEstado() == Estado.ABIERTA) {
            super.onCloseOT(e);
            EtiquetaCambioAceite etiquetaCambioAceite = new EtiquetaCambioAceite(getVehiculo());
            etiquetaCambioAceite.print();
        }
    }

    @Override
    public String toString() {
        return "\nREVISIÓN\n" +
                super.toString();
    }
}
