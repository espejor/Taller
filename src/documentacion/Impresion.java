package documentacion;

import java.io.PrintStream;

/**
 * Clase que implementa un método para imprimir Documentos
 */
public class Impresion {

    /**
     * Imprime un String en un PrintStream
     * @param output  PrintStream donde imprimir
     * @param str Cadena de texto a imprimir
     */
    public void print(PrintStream output, String str){
        output.println(str);
    }
}
