package personal;

import excepciones.HirePersonException;
import listas.ListaDeEmpleados;
import persona.Dni;
import persona.Persona;
import taller.Taller;

/**
 * Empleado del taller
 */
public abstract class Empleado extends Persona {
    // --------------  Instancia del Taller en el que trabajan
    private Taller taller;

    // ------------ Constructores
    public Empleado(Dni dni, String name, String apellido1, String apellido2) {
        super(dni, name, apellido1, apellido2);
    }

    public Empleado(int dni, String name, String apellido1, String apellido2) {
        super(dni, name, apellido1, apellido2);
    }

    public Empleado(Persona persona) {
        super(persona);
    }

    /**
     * Getter de taller
     * @return taller
     */
    public Taller getTaller() {
        return taller;
    }

    /**
     * Setter de taller
     * @param taller del tipo taller.Taller
     */
    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    /**
     * Agregar el empleado a la lista de empleado
     * Este método es sobreescrito en el caso de los Administrativos y mecánicos para personalizar las circunstancias de
     * la contratación de cada uno
     */
    public void addToList(ListaDeEmpleados listaDeEmpleados){
        if (listaDeEmpleados.estaAgregado(this))
            throw new HirePersonException(this + " ya está contratado");
        listaDeEmpleados.getColection().add(this);
    }
}
