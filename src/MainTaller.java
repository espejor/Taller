import interfaces.Reparable;
import persona.Persona;
import personal.Administrativo;
import personal.Cliente;
import personal.Gestion;
import personal.Mecanico;
import taller.Reparacion;
import taller.Revision;
import taller.Taller;
import vehiculos.Camion;
import vehiculos.Coche;
import vehiculos.Vehiculo;

public class MainTaller {
    public static void main(String[] args) {
        // Creamos un Taller
        Taller taller = new Taller();

        // Recuperamos el fichero de personal guardado. La primera vez solo dir� que no se encontrado el fichero
        taller.recuperarEmpleados();

        // Crear peronal
        Persona jefe = new Gestion(12345678,"Luis","Mart�nez","L�pez");
        Persona administrativo = new Administrativo(98765432,"Mary","P�rez","P�rez");
        Persona administrativo2 = new Administrativo(14752145,"Luis","S�nchez","Ac�n");
        Persona mecanico = new Mecanico(45632145,"Juan","Garc�a","Aguado");
        Persona electricista = new Mecanico(25852585,"Carlos","L�pez","Suarez");

        // Contratar al personal. Si ya hay alguno contratado se mostrar� el mensaje de aviso
        taller.contratar(jefe);
        taller.contratar(administrativo);
        taller.contratar(administrativo2);
        taller.contratar(mecanico);
        taller.contratar(electricista);

        // Creamos veh�culos
        Vehiculo FGF2500 = new Coche("2500FGF","Nissan","Micra", 25621);
        Vehiculo KNH1236 = new Camion("1236KNH","Pegaso","GT3500",69852);

        // Creamos clientes con sus veh�culos
        Persona p1 = new Cliente(45654565,"Manuel","Mart�n","Garc�a");
        Persona p2 = new Cliente(95147536,"Marcelo","P�rez","Aguado");

        //asignar veh�culos a las personas
        ((Cliente)p1).agregarVehiculo(FGF2500);
        ((Cliente)p2).agregarVehiculo(KNH1236);

        // Solicitud de ingreso
        Revision rv = taller.getAdministrativo().abrirRevision(KNH1236,"Cambio de Aceite");
        Reparacion rp = taller.getAdministrativo().abrirReparacion((Reparable) FGF2500,"No arranca");

        // Asignar la tarea a un mec�nico
        Mecanico mv = taller.getAdministrativo().asignarTrabajoAMecanico(rv);
        Mecanico mr = taller.getAdministrativo().asignarTrabajoAMecanico(rp);

        // Cerrar OT
        mv.cerrarOt(rv);
        mr.cerrarOt(rp);

        // Guardar el fichero de personal
        taller.guardarEmpleados();
        // Guardar el fichero de clientes
        taller.guardarClientes();

        // Listar Empleados
        System.out.println("Lista de Empleados\n" + taller.getEmpleados());

        // listar Clientes
        System.out.println("Lista de Clientes\n" + taller.getClientes());

        // listar Trabajos
        System.out.println("Lista de Trabajos\n" + taller.getTrabajos());
    }
}
