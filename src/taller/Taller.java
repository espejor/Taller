package taller;


import excepciones.HirePersonException;
import excepciones.NewClientException;
import listas.ListaDeTrabajos;
import persona.Persona;
import personal.Administrativo;
import personal.Cliente;
import personal.Empleado;
import listas.ListaDeClientes;
import listas.ListaDeEmpleados;
import vehiculos.Vehiculo;

import java.io.InvalidClassException;
import java.io.Serializable;


/**
 * Modelo de un Taller
 * Se compone de tres listas:
 *      Lista de Empleados
 *      Lista de Clientes
 *      Lista de trabajos
 */
public class Taller implements Serializable{
    private ListaDeEmpleados empleados = new ListaDeEmpleados();
    private ListaDeClientes clientes = new ListaDeClientes();
    private ListaDeTrabajos trabajos = new ListaDeTrabajos();


    /**
     * Método para contratar a un empleado
     * @param persona Admite una Persona para ser empleada
     */
    public void contratar(Persona persona){
        try {
            ((Empleado) persona).setTaller(this);
            // El método agregar lanza una Excepción en caso de que la persona ya esté empleada
            empleados.agregar((Empleado) persona);
        } catch (HirePersonException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Crea un nuevo Cliente
     * @param vehiculo Vehículo cuyo propietario pasa a ser Cliente
     */
    public void nuevoCliente(Vehiculo vehiculo){
        // Capturar Cliente
        Cliente cl = (Cliente) vehiculo.getPropietario();
        try {
            // El método agregar lanza una Excepción en caso de que la persona ya sea cliente
            clientes.agregar(cl);
        } catch (NewClientException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Getter de clientes
     * @return clientes
     */
    public ListaDeClientes getClientes() {
        return clientes;
    }

    /**
     * Getter de empleados
     * @return empleados
     */
    public ListaDeEmpleados getEmpleados() {
        return empleados;
    }



    /**
     * Guarda la Lista de Empleados en un archivo
     */
    public void guardarEmpleados(){
        empleados.save();
    }

    /**
     * Recupera una Lista de Empleados
     */
    public void recuperarEmpleados(){
        try {
            // El método recovery lanza una excepción en caso de que la clase se haya modificado
            empleados = empleados.recovery();
        } catch (InvalidClassException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Guarda la lista de Clientes
     */
    public void guardarClientes() {
        clientes.save();
    }

    /**
     * Comprueba si un vehículo está ingresado
     * @param vehiculo Vehículo a comprobar
     * @return True si está ingresado. False en caso contario
     */
    private boolean estaIngresado(Vehiculo vehiculo){
        return trabajos.getUnTrabajo(vehiculo) != null;
    }


    /**
     * Getter de trabajos
     * @return trabajos
     */
    public ListaDeTrabajos getTrabajos() {
        return trabajos;
    }

    /**
     * Devuelve el administrativo del Taller
     * @return Administrativo único
     */
    public Administrativo getAdministrativo(){
        return empleados.getAdministrativo();
    }
}
