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

        // Recuperamos el fichero de personal guardado. La primera vez solo dirá que no se encontrado el fichero
        taller.recuperarEmpleados();

        // Crear peronal
        Persona jefe = new Gestion(12345678,"Luis","Martínez","López");
        Persona administrativo = new Administrativo(98765432,"Mary","Pérez","Pérez");
        Persona administrativo2 = new Administrativo(14752145,"Luis","Sánchez","Acón");
        Persona mecanico = new Mecanico(45632145,"Juan","García","Aguado");
        Persona electricista = new Mecanico(25852585,"Carlos","López","Suarez");

        // Contratar al personal. Si ya hay alguno contratado se mostrará el mensaje de aviso
        taller.contratar(jefe);
        taller.contratar(administrativo);
        taller.contratar(administrativo2);
        taller.contratar(mecanico);
        taller.contratar(electricista);

        // Creamos vehículos
        Vehiculo FGF2500 = new Coche("2500FGF","Nissan","Micra", 25621);
        Vehiculo KNH1236 = new Camion("1236KNH","Pegaso","GT3500",69852);

        // Creamos clientes con sus vehículos
        Persona p1 = new Cliente(45654565,"Manuel","Martín","García");
        Persona p2 = new Cliente(95147536,"Marcelo","Pérez","Aguado");

        //asignar vehículos a las personas
        ((Cliente)p1).agregarVehiculo(FGF2500);
        ((Cliente)p2).agregarVehiculo(KNH1236);

        // Solicitud de ingreso
        Revision rv = taller.getAdministrativo().abrirRevision(KNH1236,"Cambio de Aceite");
        Reparacion rp = taller.getAdministrativo().abrirReparacion((Reparable) FGF2500,"No arranca");

        // Asignar la tarea a un mecánico
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
