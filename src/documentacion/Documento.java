package documentacion;

import accesoFicheros.AccessTextFile;
import accesoFicheros.Fichero;
import interfaces.Archivable;
import interfaces.Imprimible;
import taller.Trabajo;

import java.io.*;

/**
 * Clase abstracta que representa un documento.
 * Debe ser Imprimible, Archivable y Serializable
 */
public abstract class Documento implements Imprimible, Archivable, Serializable {
    //String file;
    protected Fichero file;
    protected Trabajo trabajo;



    /**
     * Archiva el objeto
     */
    public void save() {
        new AccessTextFile().save(this.toString(),file);
    }


    /**
     * Recupera el objeto previamente archivado
     * @return Un Objeto previamente archivado
     */
    public String recovery(){
        String output = "";
        try {
            output = new AccessTextFile().recovery(file);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return output;
    }

    /**
     * Método privado que da formato y personaliza el título del documento
     * @param titulo Texto título del documento
     * @return Cadena de texto con el título formatizado
     */
    protected String titulo(String titulo){
        String out ="";
        for (int i = 0; i < titulo.length() - 1; i++) {
            out += "¯";
        }
        return titulo + out;
    }

    @Override
    public String toString() {
        return trabajo.toString();
    }
}
