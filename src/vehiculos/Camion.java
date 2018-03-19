package vehiculos;

/**
 * La Clase Camion es un Vehiculo y por tanto es Revisable, pero no es reparable
 */
public class Camion extends Vehiculo {
    public Camion(String matricula, String marca, String modelo,int kms) {
        super(matricula, marca, modelo,kms);
    }


    /**
     * Establece el intervalo en Kms entre revisiones, seg�n el tipo de veh�culo
     */
    @Override
    public void estableceIntervaloKms() {
        intervaloKms = 3000;
    }
}
