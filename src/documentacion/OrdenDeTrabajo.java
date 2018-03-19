package documentacion;

import accesoFicheros.Fichero;
import taller.Trabajo;


/**
 * Documento que se abre cuando se van a iniciar las tareas de reparación o revisión.
 * Hereda de Documento
 */
public class OrdenDeTrabajo extends Documento {

    /**
     * Constructor que recibe como parámetro el Trabajo relacionado.
     * Establece el path del fichero donde se guardará la OT
     * Imprime la OT
     * Guarda la OT
     * @param trabajo Relacionado con este parte
     */
    public OrdenDeTrabajo(Trabajo trabajo) {
        String matricula = trabajo.getVehiculo().getMatricula();

        this.trabajo = trabajo;
        this.file = new Fichero("src/files/ot" + matricula + ".txt");
        // Imprimir OT
        print();
        // Guardar en un fichero
        save();
    }


    @Override
    public String toString() {
        return titulo("Orden de Trabajo\n") +
                super.toString() +
                trabajo.getMecanico() + "\n" +
                "OT " + trabajo.getEstado() + "\n";
    }

}
