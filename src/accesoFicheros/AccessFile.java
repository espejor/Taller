package accesoFicheros;



public abstract class AccessFile {
    public abstract Object recovery(Fichero file);
    public abstract void save(Object txt, Fichero file);
}
