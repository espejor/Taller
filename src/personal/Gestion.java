package personal;

import excepciones.HirePersonException;
import listas.ListaDeEmpleados;
import persona.Dni;
import persona.Persona;

/**
 * Empleados dedicados a gestión del taller. No tiene relevancia para este ejercicio
 */
public class Gestion extends Empleado {
    public Gestion(Dni dni, String name, String apellido1, String apellido2) {
        super(dni, name, apellido1, apellido2);
    }

    public Gestion(int dni, String name, String apellido1, String apellido2) {
        super(dni, name, apellido1, apellido2);
    }

    public Gestion(Persona persona) {
        super(persona);
    }



    @Override
    public String toString() {
        return "Gestión: " + super.toString();
    }
}
