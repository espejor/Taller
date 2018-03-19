package interfaces;


import documentacion.Impresion;

/**
 * Interface a aplicar a las clases que se puedan imprimir
 */
public interface Imprimible{

    /**
     * M�todo que imprime un objeto.
     * Tiene una implementaci�n por defecto que llama al m�todo print() de la clase Impresion y que requiere
     * un PrintStream y una cadena de texto;
     */
    default void print(){
        new Impresion().print(System.out,this.toString());
    }
}
