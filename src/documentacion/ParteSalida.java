package documentacion;

import accesoFicheros.Fichero;
import personal.Mecanico;
import taller.Trabajo;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Documento que representa un Parte de Salida de un veh�culo cuando se finaliza o se anula su trabajo
 * Hereda de la clase Documento
 */
public class ParteSalida extends Documento {

    /**
     * Constructor que recibe como par�metro el Trabajo relacionado.
     * establece el path del fichero donde se guardar� el parte
     * Imprime el parte
     * Guarda el parte
      * @param trabajo Relacionado con este parte
     */
    public ParteSalida(Trabajo trabajo) {
        this.trabajo = trabajo;
        this.file = new Fichero( "src/files/parteSalida" + this.trabajo.getVehiculo().getMatricula() + ".txt");
        // Imprimir Parte de Salida
        print();
        // Guardar
        save();
    }

    @Override
    public String toString() {
        Mecanico m = trabajo.getMecanico();
        // Si no hay mec�nico es que la orden de trabajo no se lleg� a abrir
        String reparadoPor = m != null ? "Le repar� su veh�culo: " + m.toString() + "\n" : "La OT ha sido cancelada\n";
        return  titulo("Parte de Salida\n") +
                super.toString() + "\n" +
                reparadoPor +
                "ORDEN DE TRABAJO CERRADA\n";
    }
}
