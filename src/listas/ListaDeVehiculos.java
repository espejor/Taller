package listas;

import excepciones.AttachVehicleException;
import vehiculos.Vehiculo;

/**
 * Implementa una Lista de Veh�culos mediante un ArrayList
 * Implementa las interfaces Serializable y Listable, que le obliga a implementar el m�todo List()
 * Implementa la interfaz Lista para agregar y comprobar si ya se ha agregado un veh�culo
 */
public class ListaDeVehiculos extends Lista<Vehiculo>{

    /**
     * Agregar un elemento a una colecci�n
     * @param vehiculo Objeto a agregar
     * @throws AttachVehicleException Excepci�n que se ha de lanzar si ya se encuentra el elemento a agregar
     */
    public void agregar(Vehiculo vehiculo) throws AttachVehicleException {
        if (estaAgregado(vehiculo))
            throw new AttachVehicleException("El veh�culo " + vehiculo.getMatricula() +
                    " ya est� en la lista de veh�culos");
        coleccion.add(vehiculo);
    }


}
