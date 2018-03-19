package personal;

import excepciones.AttachVehicleException;
import persona.Dni;
import persona.Persona;
import listas.ListaDeVehiculos;
import vehiculos.Vehiculo;

public class Cliente extends Persona {
    private final ListaDeVehiculos listaDeVehiculos = new ListaDeVehiculos();

    public Cliente(Dni dni, String name, String apellido1, String apellido2) {
        super(dni, name, apellido1, apellido2);
    }

    public Cliente(int dni, String name, String apellido1, String apellido2) {
        super(dni, name, apellido1, apellido2);
    }

    public Cliente(Persona persona) {
        super(persona);
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        try {
            listaDeVehiculos.agregar(vehiculo);
            vehiculo.setPropietario(this);
        } catch (AttachVehicleException e) {
            System.out.println(e.getMessage());
        }
    }

}
