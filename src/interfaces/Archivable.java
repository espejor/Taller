package interfaces;

import java.io.InvalidClassException;

/**
 * Interface que establece las operaciones que se deben realizar cuando el objeto es archivable
 */
public interface Archivable{
    /**
     * Archiva el objeto
     */
    void save();

    /**
     * Recupera el objeto previamente archivado
     * @return Un Objeto previamente archivado
     */
    Object recovery() throws InvalidClassException;
}
