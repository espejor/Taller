package accesoFicheros;

import java.io.*;

/**
 * Clase que modela un Fichero de datos
 * Implementa la interfaz Serializable
 */
public class Fichero implements Serializable {
    /**
     * Objeto de la clase Fichero donde se guardarán los datos
     */
    protected final File file;

    /**
     * Constructor que recibe el path del HD donde se encuentra
     * @param pathFile URL del fichero
     */
    public Fichero(String pathFile) {
        file = new File(pathFile);
    }

    /**
     * Getter de file
     * @return file
     */
    public File getFile() {
        return file;
    }








}
