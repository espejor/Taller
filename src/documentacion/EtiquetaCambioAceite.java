package documentacion;

import fecha.Fecha;
import interfaces.Imprimible;
import taller.Revision;
import vehiculos.Vehiculo;

import java.io.PrintStream;
import java.util.Calendar;

/**
 * Clase que representa una etiqueta que se cuelga en el veh�culo tras la Revisi�n
 * Debe ser Imprimible
 */
public class EtiquetaCambioAceite implements Imprimible {
    /**
     * Veh�culo al que se le ha hecho la revisi�n
     */
    private Vehiculo vehiculo;

    /**
     * Constructor que recibe el veh�culo objeto de la revisi�n
     * @param vehiculo Objeto de la revisi�n
     */
    public EtiquetaCambioAceite(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Impresi�n de una etiqueta de Cambio de aceite
      * @return Cadena de texto con la etiqueta
     */
    @Override
    public String toString() {
        Fecha f = new Fecha();
        f.add(Calendar.DAY_OF_YEAR,365);
        return  "   _______________________________________________________________\n" +
                "  /  CAMBIO DE ACEITE\n" +
                " /   Veh�culo: " + vehiculo + "\n" +
                " \\   Kil�metros: " + vehiculo.getKms() + "\n" +
                "  \\  Pr�ximo cambio: " + f + " o a los " + vehiculo.proximaRevision() + " km,s\n" +
                "   ���������������������������������������������������������������\n";
    }
}
