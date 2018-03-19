package accesoFicheros;

import documentacion.Impresion;

import java.io.*;
import java.util.Scanner;

public class AccessTextFile extends AccessFile {

    public void save(Object txt, Fichero file){
        try {
            new Impresion().print(new PrintStream(file.getFile()), (String) txt);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String recovery (Fichero file) throws NullPointerException{
        Scanner input;
        String output = "";
        try {
            input = new Scanner(file.getFile());
            while (input.hasNextLine()){
                output +=(input.nextLine());
            }
            if (output.equals(""))
                throw new NullPointerException("No hay datos");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output;
    }

}
