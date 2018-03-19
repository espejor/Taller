package personal;

import eventos.EventWorkShop;
import excepciones.HirePersonException;
import excepciones.NewWorkException;
import fecha.Fecha;
import interfaces.*;
import listas.ListaDeEmpleados;
import listas.ListaDeTrabajos;
import persona.Dni;
import persona.Persona;
import taller.Reparacion;
import taller.Revision;
import taller.Trabajo;
import vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.EventListener;

/**
 * Empleados dedicados a administraci�n del taller. No tiene relevancia para este ejercicio
 */
public class Administrativo extends Empleado implements EventSource{
    // ------------- Lista de listeners
    private ArrayList<EventWorkAsignedListener> workAsignedListener= new ArrayList<EventWorkAsignedListener>();

    // ------------- Constructores -------------
    public Administrativo(Dni dni, String name, String apellido1, String apellido2) {
        super(dni, name, apellido1, apellido2);
    }

    public Administrativo(int dni, String name, String apellido1, String apellido2) {
        super(dni, name, apellido1, apellido2);
    }

    public Administrativo(Persona persona) {
        super(persona);
    }

    // ------------- Fin constructores

    @Override
    public String toString() {
        return "Administrativo: " + super.toString();
    }

    /**
     * Personalizaci�n del m�todo addToList para comprobar que solo se contrata a un administrativo
     * @param l Lista de Empleados donde agregar
     */
    public void addToList(ListaDeEmpleados l){
        if (l.existeAdministrativo())
            throw new HirePersonException(this + " No ser� contratado porque ya existe un administrativo contratado");
        l.getColection().add(this);
    }


    // --------------------- M�todos de la interface EventSource
    @Override
    public void addListener(EventListener listener){
        if (!isRegister(listener))
            workAsignedListener.add((EventWorkAsignedListener) listener);
    }


    @Override
    public void removeListener(EventListener listener) {
        if (isRegister(listener))
            workAsignedListener.remove(listener);
    }

    @Override
    public boolean isRegister(EventListener listener) {
        if (listener instanceof EventWorkAsignedListener)
            return workAsignedListener.contains(listener);
        return false;
    }

    // -------------- Fin EventSource

    /**
     * Solicitar una Revisi�n de un Veh�culo
     * @param vehiculo Veh�culo a Revisar
     * @param motivo Motivo de la Revisi�n
     */
    public Revision abrirRevision(Revisable vehiculo, String motivo){
        Revision r = vehiculo.abrirRevision(motivo,new Fecha());
        abrirTrabajo(r);
        return r;
    }

    /**
     * Solicitar una Reparaci�n de un Veh�culo
     * @param vehiculo Veh�culo a Reparar
     * @param motivo Motivo de la Reparaci�n
     */
    public Reparacion abrirReparacion(Reparable vehiculo, String motivo) {
        Reparacion r = vehiculo.abrirReparacion(motivo,new Fecha());
        abrirTrabajo(r);
        return r;
    }

    /**
     * Solicitar una Reparaci�n de un Veh�culo
     * @param trabajo Trabajo a a�adir
     */
    private void abrirTrabajo(Trabajo trabajo) {
        // Obtener la lista de trabajos del taller
        ListaDeTrabajos trabajos = getTaller().getTrabajos();
        try {
            // Agregar a la lista de Trabajos el nuevo trabajo
            trabajos.agregar(trabajo);
            // Agregar el cliente a la lista de clientes
            getTaller().nuevoCliente(trabajo.getVehiculo());
        } catch (NewWorkException e) {
            e.getMessage();
        }
    }

    /**
     * Asigna un trabajo a un mec�nico comprobando previamente el mec�nico que menos �rdenes de trabajo abiertas tiene
     * A continuaci�n se lanza el evento de asignaci�n de trabajo a los listeners
     * @param trabajo Trabajo a asignar
     * @return M�canico al que se le ha asignado el trabajo
     */
    public Mecanico asignarTrabajoAMecanico(Trabajo trabajo){
        Mecanico m = getTaller().getEmpleados().selectMecanicoConMenorCargaDeTrabajo();
        trabajo.setMecanico(m);
        lanzarEventoAsignarTrabajo(trabajo);
        return m;
    }

    /**
     * Lanza el evento de asignar un trabajo solo al mec�nico que tiene el trabajo asignado
     * @param t Trabajo asignado
     */
    private void lanzarEventoAsignarTrabajo(Trabajo t) {
        EventWorkShop e = new EventWorkShop(this,t);
        for (EventWorkAsignedListener l: workAsignedListener){
            // Lo mandamos solo al mec�nico asignado
            if (l.equals(t.getMecanico()))
                l.onWorkAsigned(e);
        }
    }


}
