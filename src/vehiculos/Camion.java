package vehiculos;

/**
 * La Clase Camion es un Vehiculo y por tanto es Revisable, pero no es reparable
 */
public class Camion extends Vehiculo {
    public Camion(String matricula, String marca, String modelo,int kms) {
        super(matricula, marca, modelo,kms);
    }


    /**
     * Establece el intervalo en Kms entre revisiones, según el tipo de vehículo
     */
    @Override
    public void estableceIntervaloKms() {
        intervaloKms = 3000;
    }
}
