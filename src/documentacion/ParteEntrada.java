package documentacion;

import accesoFicheros.Fichero;
import taller.Trabajo;

import java.io.*;


/**
 * Documento que representa un Parte de Entrada de un veh�culo cuando se inicia su trabajo
 * Hereda de la clase Documento
 */
public class ParteEntrada extends Documento {

    /**
     * Constructor que recibe como par�metro el Trabajo relacionado.
     * Establece el path del fichero donde se guardar� el parte
     * Imprime el parte
     * Guarda el parte
     * @param trabajo Relacionado con este parte
     */
    public ParteEntrada(Trabajo trabajo) {
        this.trabajo = trabajo;
        file = new Fichero("src/files/parteEntrada" + this.trabajo.getVehiculo().getMatricula() + ".txt");
        print();
        save();
    }


    @Override
    public String toString() {
        return titulo("Parte de Entrada\n") +
                super.toString();
    }
}
