package listas;

import excepciones.AttachVehicleException;
import vehiculos.Vehiculo;

/**
 * Implementa una Lista de Vehículos mediante un ArrayList
 * Implementa las interfaces Serializable y Listable, que le obliga a implementar el método List()
 * Implementa la interfaz Lista para agregar y comprobar si ya se ha agregado un vehículo
 */
public class ListaDeVehiculos extends Lista<Vehiculo>{

    /**
     * Agregar un elemento a una colección
     * @param vehiculo Objeto a agregar
     * @throws AttachVehicleException Excepción que se ha de lanzar si ya se encuentra el elemento a agregar
     */
    public void agregar(Vehiculo vehiculo) throws AttachVehicleException {
        if (estaAgregado(vehiculo))
            throw new AttachVehicleException("El vehículo " + vehiculo.getMatricula() +
                    " ya está en la lista de vehículos");
        coleccion.add(vehiculo);
    }


}
