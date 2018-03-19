package accesoFicheros;


import java.io.*;

public class AccessObjectFile extends AccessFile {

    public void save(Object obj, Fichero file) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file.getFile());
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el Fichero");
        } catch (IOException e) {
            System.out.println("Error de I/O");
        }finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    public Serializable recovery(Fichero file) throws NullPointerException {
        FileInputStream fis;
        Serializable p = null;
        try {
            fis = new FileInputStream(file.getFile());
            ObjectInputStream ois = new ObjectInputStream(fis);
            p = (Serializable) ois.readObject();
            if (p == null)
                throw new NullPointerException("No hay datos");
            ois.close();
            fis.close();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new NullPointerException("No hay datos");
        }
        return p;
    }
}
