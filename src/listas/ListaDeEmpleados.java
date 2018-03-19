package listas;

import accesoFicheros.AccessObjectFile;
import accesoFicheros.Fichero;
import excepciones.HirePersonException;
import interfaces.Archivable;
import personal.Administrativo;
import personal.Empleado;
import personal.EmpleadoIterator;
import personal.Mecanico;

import java.io.*;
import java.util.Iterator;

/**
 * Lista de los empleados del taller.
 * Implementa las interfaces;
 * Serializable para poder guardar la lista en un fichero
 * Listable para poder hacer una lista de la colección
 * Archivable para poder guardar la lista en formato texto
 * Iterable para poder crear un iterador sobre la lista
 * Hereda de Lista
 * Se implementa mediante un ArrayList y contiene un fichero donde guardar la lista
 */
public class ListaDeEmpleados extends Lista<Empleado> implements Archivable, Iterable {
    private final Fichero ficheroEmpleados;

    /**
     * Constructor que determina el fichero de texto donde se va a archivar una copia de la lista en formato de texto
     */
    public ListaDeEmpleados() {
        ficheroEmpleados = new Fichero("src/files/ficheroEmpleados.txt");
    }

    /**
     * Agregar un elemento a una colección
     * @param persona Objeto a agregar
     * @throws HirePersonException Excepción que se ha de lanzar si ya se encuentra el elemento a agregar
     */
    @Override
    public void agregar(Empleado persona) throws HirePersonException {
        persona.addToList(this);
    }

    /**
     * Método que comprueba si ya hay un administrativo contratado ya que solo puede haber uno
     * @return true si ya existe un administrativo
     */
    public boolean existeAdministrativo() {
        for (Empleado e : coleccion) {
            if (e instanceof Administrativo)
                return true;
        }
        return false;
    }


    /**
     * Selecciona el Mecánico que tiene el menor número de OT,s abiertas
     * @return Mecánico con menor número de OT,s abiertas
     */
    public Mecanico selectMecanicoConMenorCargaDeTrabajo() {
        Mecanico m = null;
        int menor = Integer.MAX_VALUE;
        int newMenor;
        Iterator<Empleado> iterator = coleccion.iterator();
        while (iterator.hasNext()) {
            Empleado p = iterator.next();
            if (p instanceof Mecanico && (newMenor = ((Mecanico) p).getOtsAbiertas()) < menor) {
                m = (Mecanico) p;
                menor = newMenor;
            }
        }
        return m;
    }

    @Override
    public String toString() {
        return list();
    }


    /**
     * Método para Listar una colección. Implementado mediante un ITERADOR
     * @return Un cadena en forma de lista
     */
    @Override
    public String list() {
        EmpleadoIterator it = (EmpleadoIterator) iterator();
        String out = "";
        while (it.hasNext()) {
            out += it.next() + "\n";
        }
        return out;
    }


    /**
     * Archiva el objeto
     */
    public void save() {
        new AccessObjectFile().save(this, ficheroEmpleados);
    }

    /**
     * Recupera el objeto previamente archivado
     * @return Un Objeto previamente archivado
     */
    public ListaDeEmpleados recovery() throws InvalidClassException, NullPointerException {
        ListaDeEmpleados l;
        if ((l = (ListaDeEmpleados) new AccessObjectFile().recovery(ficheroEmpleados)) == null)
            throw new NullPointerException("Fichero vacío");
        return l;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return new EmpleadoIterator(this);
    }

    /**
     * Devuelve ul administrativo de la empresa
     * @return Administrativo
     */
    public Administrativo getAdministrativo() {
        for (Empleado e : coleccion) {
            if (e instanceof Administrativo)
                return (Administrativo) e;
        }
        return null;
    }
}
