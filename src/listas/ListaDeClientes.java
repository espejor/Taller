package listas;

import accesoFicheros.AccessFile;
import accesoFicheros.AccessObjectFile;
import accesoFicheros.Fichero;
import excepciones.NewClientException;
import interfaces.Archivable;
import personal.Cliente;

import java.io.*;

/**
 *Lista de los Clientes del Taller
 * Archivable permite archivar la lista en un archivo de texto
 */
public class ListaDeClientes extends Lista<Cliente> implements  Archivable{

    /**
     * Fichero de texto donde guardar los clientes en forma de lista
     */
    private final Fichero fichero;

    /**
     * Constructor. Llama al constructor de la clase padre y crea la clase FicheroClientes
     */
    public ListaDeClientes() {
        super();
        fichero = new Fichero("src/files/ficheroClientes.txt");
    }


    /**
     * Agregar un elemento a una colección
     * @param persona Objeto a agregar
     * @throws NewClientException Excepción que se ha de lanzar si ya se encuentra el elemento a agregar
     */
    public void agregar(Cliente persona) throws NewClientException{
        if (estaAgregado(persona))
            throw new NewClientException(persona + " ya es cliente");
        coleccion.add(persona);
    }



    /**
     * Archiva el objeto
     */
    public void save() {
        new AccessObjectFile().save(this,fichero);
    }

    /**
     * Recupera el objeto previamente archivado
     * @return Un Objeto previamente archivado
     */
    public ListaDeClientes recovery() throws InvalidClassException {
        return (ListaDeClientes) new AccessObjectFile().recovery(fichero);
    }

    @Override
    public String toString() {
        return list();
    }


}
