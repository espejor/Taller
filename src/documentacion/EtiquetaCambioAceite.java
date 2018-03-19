package documentacion;

import fecha.Fecha;
import interfaces.Imprimible;
import taller.Revision;
import vehiculos.Vehiculo;

import java.io.PrintStream;
import java.util.Calendar;

/**
 * Clase que representa una etiqueta que se cuelga en el vehículo tras la Revisión
 * Debe ser Imprimible
 */
public class EtiquetaCambioAceite implements Imprimible {
    /**
     * Vehículo al que se le ha hecho la revisión
     */
    private Vehiculo vehiculo;

    /**
     * Constructor que recibe el vehículo objeto de la revisión
     * @param vehiculo Objeto de la revisión
     */
    public EtiquetaCambioAceite(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Impresión de una etiqueta de Cambio de aceite
      * @return Cadena de texto con la etiqueta
     */
    @Override
    public String toString() {
        Fecha f = new Fecha();
        f.add(Calendar.DAY_OF_YEAR,365);
        return  "   _______________________________________________________________\n" +
                "  /  CAMBIO DE ACEITE\n" +
                " /   Vehículo: " + vehiculo + "\n" +
                " \\   Kilómetros: " + vehiculo.getKms() + "\n" +
                "  \\  Próximo cambio: " + f + " o a los " + vehiculo.proximaRevision() + " km,s\n" +
                "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n";
    }
}
