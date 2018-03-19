package taller;

import fecha.Fecha;
import interfaces.Reparable;
import vehiculos.Vehiculo;

/**
 * Clase concreta de un tipo de trabajo que modela una Reparación
 */
public class Reparacion extends Trabajo {
    public Reparacion(Reparable vehiculo, String motivo, Fecha fechaIngreso) {
        super((Vehiculo) vehiculo, motivo, fechaIngreso);
    }



    @Override
    public String toString() {
        return "\nREPARACIÓN\n" +
                super.toString();
    }
}
