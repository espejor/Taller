package listas;

import accesoFicheros.AccessObjectFile;
import accesoFicheros.Fichero;
import excepciones.NewWorkException;
import interfaces.Archivable;
import taller.Estado;
import taller.Trabajo;
import vehiculos.Vehiculo;
import java.io.*;

/**
 * Modela la lista de los trabajos que se realizan el el taller.
 * Implementa las interfaces Listable, para poder listar los trabajos
 * Implementa la interface Archivable para poder archivar la lista en un fichero
 * Implementa la interface Lista para determinar las operaciones de la Lista
 */
public class ListaDeTrabajos extends Lista<Trabajo> implements Archivable {
    /**
     * Fichero donde almacenar la Lista
     */
    private Fichero fichero;


    /**
     * Constructor sin parámetros. Se fija el fichero donde se va a guardar la Lista
     */
    public ListaDeTrabajos() {
        fichero = new Fichero("src/files/fichero.txt");
    }


    /**
     * Agregar un elemento a una colección
     * @param trabajo Objeto a agregar
     * @throws NewWorkException Excepción que se ha de lanzar si ya se encuentra el elemento a agregar
     */
    @Override
    public void agregar(Trabajo trabajo) throws NewWorkException {
        if (estaAgregado(trabajo))
            throw new NewWorkException("El trabajo ya está agregado");
        coleccion.add(trabajo);
    }



    /**
     * Determina un Trabajo en estado No CERRADO correspondiente a un Vehículo determinado
     * @param vehiculo Vehículo del cual se pretende obtener el Trabajo
     * @return Trabajo obtenido correspondiente al Vehículo
     */
    public Trabajo getUnTrabajo(Vehiculo vehiculo){
        for (Trabajo t: coleccion){
            if (t.getVehiculo() == vehiculo && t.getEstado() != Estado.CERRADA)
                return t;
        }
        return null;
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
    @Override
    public ListaDeTrabajos recovery() throws InvalidClassException {
        return (ListaDeTrabajos) new AccessObjectFile().recovery(fichero);
    }

    @Override
    public String toString() {
        return list();
    }



}
