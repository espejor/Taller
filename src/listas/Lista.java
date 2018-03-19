package listas;


import java.io.*;
import java.util.ArrayList;

/**
 * * Implementa las interfaces:
 * Serializable para guardar y recuperar los objetos
 * Listable para poder realizar listas de la colección
 * @param <T> Parámetro que permite el control de Tipos de los elementos a guardar en la Lista
 */
public abstract class Lista<T> implements Serializable {
    /**
     * ArrayList para guardar los Elementos de la Lista
     */
    protected final ArrayList<T> coleccion = new ArrayList<T>();

    /**
     * Agregar un elemento a una colección
     * @param obj Objeto a agregar
     * @throws Exception Excepción que se ha de lanzar si ya se encuentra el elemento a agregar
     */
    public abstract void agregar(T obj)throws Exception;


    /**
     * Comprueba si un Objeto ya está en la colección
     * @param obj Objeto a comprobar
     * @return Cierto si ya está en la colección
     */
    public boolean estaAgregado(T obj) {
        return coleccion.contains(obj);
    }


    /**
     * Getter de la colección
     * @return coleccion
     */
    public ArrayList<T> getColection() {
        return coleccion;
    }


        /**
         * Método para Listar una colección
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
