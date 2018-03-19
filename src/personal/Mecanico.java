package personal;

import eventos.EventWorkShop;
import excepciones.NewWorkException;
import interfaces.EventCloseOTListener;
import interfaces.EventInitOTListener;
import interfaces.EventSource;
import interfaces.EventWorkAsignedListener;
import listas.ListaDeEmpleados;
import listas.ListaDeTrabajos;
import persona.Dni;
import persona.Persona;
import taller.Trabajo;

import java.util.ArrayList;
import java.util.EventListener;

/**
 * Mec�nico del taller es un tipo de Empleado
 */
public class Mecanico extends Empleado implements EventSource,EventWorkAsignedListener{
    private ArrayList<EventListener> OTListeners = new ArrayList<EventListener>();

    /**
     * OT,s que en un momento dado tiene abiertas el mec�nico
     */
    private int otsAbiertas;
    /**
     * Trabajos asignados al mec�nico
     */
    //private final ArrayList<Trabajo> trabajosAsignados = new ArrayList<Trabajo>();
    private ListaDeTrabajos trabajosAsignados = new ListaDeTrabajos();

    /**
     * Constructor parametrizado con los atributos de Persona
     * @param dni Dni
     * @param name Nombre
     * @param apellido1 1� Apellido
     * @param apellido2 2� Apellido
     */
    public Mecanico(Dni dni, String name, String apellido1, String apellido2) {
        super(dni, name, apellido1, apellido2);
    }

    public Mecanico(int dni, String name, String apellido1, String apellido2) {
        this(new Dni(dni), name, apellido1, apellido2);
    }

    public Mecanico(Persona persona) {
        this(persona.getDni(),persona.getName(),persona.getApellido1(),persona.getApellido2());
    }

    //---------------------------- Fin Constructores

    /**
     * M�todo sobreescrito que particulariza el modo como el objeto se a�ade a la lista
     * Adem�s de agregarse a la lista se a�ade a la lista ed listeners del administrativo
     * @param listaDeEmpleados Lista a la que agregar el elemento
     */
    @Override
    public void addToList(ListaDeEmpleados listaDeEmpleados) {
        super.addToList(listaDeEmpleados);
        // Agregarse a la lista de listeners de Admministrativo
        listaDeEmpleados.getAdministrativo().addListener(this);
    }

    /**
     * asigna un trabajo a la lista de OT,s
     * @param t Trabajo a asignar
     */
    private void asignarOT(Trabajo t){
        try {
            trabajosAsignados.agregar(t);
            otsAbiertas++;
        } catch (NewWorkException e) {
            System.out.println(e.getMessage());;
        }
    }

    /**
     * Getter de otsAbiertas
     * @return otsAbiertas
     */
    public int getOtsAbiertas() {
        return otsAbiertas;
    }

    @Override
    public String toString() {
        return "Mec�nico: " + super.toString();
    }

    /**
     * Decrementa el n�mero de obras abiertas
     */
    public void cerrarOt(Trabajo t) {
        otsAbiertas--;
        if (existeTrabajo(t))
            lanzarEventoCloseOT(t);
    }

    /**
     * Comprueba si un trabajo est� asignado a este mec�nico
     * @param t Trabajo a comprobar
     * @return true si est� asignado
     */
    private boolean existeTrabajo (Trabajo t){
        return trabajosAsignados.estaAgregado(t);
    }

    /**
     * M�todo que se ejecuta cuando se le asigna un trabajo al mec�nico
     * Agrega el listener del trabajo para actualizar su estado
     * Lanza un evento para crear la OT
     * Asigna l trabajo a la lista de trabajos del mec�nico
      * @param e Evento recibido
     */
    @Override
    public void onWorkAsigned(EventWorkShop e) {
        addListener(e.getTrabajo());
        lanzarEventoInitOT(e.getTrabajo());
        asignarOT(e.getTrabajo());
    }

    // ------------ M�todos de la Interface EventSource

    @Override
    public void addListener(EventListener listener) {
        if(!isRegister(listener))
            OTListeners.add(listener);
    }

    @Override
    public void removeListener(EventListener listener) {
        if(!isRegister(listener))
            OTListeners.remove(listener);
    }

    @Override
    public boolean isRegister(EventListener listener) {
        return OTListeners.contains(listener);
    }

    // --------------- Fin EventSource

    /**
     * Lanza el evento de inicio de una OT
      * @param t Trabajo de la OT
     */
    private void lanzarEventoInitOT(Trabajo t){
        EventWorkShop e = new EventWorkShop(this,t);
        for (EventListener listener: OTListeners) {
            ((EventInitOTListener)listener).onInitOT(e);
        }
    }

    /**
     * Lanza el evento de cierre de una OT
     * @param t Trabajo de la OT
     */
    private void lanzarEventoCloseOT(Trabajo t){
        EventWorkShop e = new EventWorkShop(this,t);
        for (EventListener listener: OTListeners) {
            ((EventCloseOTListener)listener).onCloseOT(e);
        }
    }
}
