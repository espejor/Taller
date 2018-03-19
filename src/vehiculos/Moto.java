package vehiculos;

import interfaces.Reparable;

/**
 * Subclase de Vehiculo que modela una Moto e implementa la interfaz Reparable
 */
public class Moto extends Vehiculo implements Reparable {
    public Moto(String matricula, String marca, String modelo,int kms) {
        super(matricula, marca, modelo,kms);
    }

    /**
     * Establece el intervalo en Kms entre revisiones, seg�n el tipo de veh�culo
     */
    @Override
    public void estableceIntervaloKms() {
        intervaloKms = 5000;
    }
}
