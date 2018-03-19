package listas;


import java.io.*;
import java.util.ArrayList;

/**
 * * Implementa las interfaces:
 * Serializable para guardar y recuperar los objetos
 * Listable para poder realizar listas de la colecci�n
 * @param <T> Par�metro que permite el control de Tipos de los elementos a guardar en la Lista
 */
public abstract class Lista<T> implements Serializable {
    /**
     * ArrayList para guardar los Elementos de la Lista
     */
    protected final ArrayList<T> coleccion = new ArrayList<T>();

    /**
     * Agregar un elemento a una colecci�n
     * @param obj Objeto a agregar
     * @throws Exception Excepci�n que se ha de lanzar si ya se encuentra el elemento a agregar
     */
    public abstract void agregar(T obj)throws Exception;


    /**
     * Comprueba si un Objeto ya est� en la colecci�n
     * @param obj Objeto a comprobar
     * @return Cierto si ya est� en la colecci�n
     */
    public boolean estaAgregado(T obj) {
        return coleccion.contains(obj);
    }


    /**
     * Getter de la colecci�n
     * @return coleccion
     */
    public ArrayList<T> getColection() {
        return coleccion;
    }


        /**
         * M�todo para Listar una colecci�n
         * @return Un cadena en forma de lista
         */
    public String list() {
        String out = "";
        for (T p: coleccion){
            out += p + "\n";
        }
        return out;
    }
}
