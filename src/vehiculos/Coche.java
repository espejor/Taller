package vehiculos;

import interfaces.Reparable;

/**
 * Subclase de Vehiculo que modela un Coche e implementa la interfaz Reparable
 */
public class Coche extends Vehiculo implements Reparable{
    public Coche(String matricula, String marca, String modelo,int kms) {
        super(matricula, marca, modelo,kms);
    }

    /**
     * Establece el intervalo en Kms entre revisiones, seg�n el tipo de veh�culo
     */
    @Override
    public void estableceIntervaloKms() {
        intervaloKms = 10000;
    }
}
