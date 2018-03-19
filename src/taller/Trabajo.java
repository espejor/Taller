package taller;

import documentacion.OrdenDeTrabajo;
import documentacion.ParteEntrada;
import documentacion.ParteSalida;
import eventos.EventWorkShop;
import fecha.Fecha;
import interfaces.EventCloseOTListener;
import interfaces.EventInitOTListener;
import personal.Mecanico;
import vehiculos.Vehiculo;

import java.io.Serializable;

/**
 * Clase abstracta que modela los trabajos que se realizan en el taller. es Serializable
 */
public abstract class Trabajo implements Serializable, EventInitOTListener, EventCloseOTListener{
    /**
     * Veh�culo sobre el que se realiza el trabajo
     */
    private final Vehiculo vehiculo;
    /**
     * Motivo del trabajo que coincidir� con el motivo del ingreso
     */
    private String motivo;
    /**
     * Mec�nico al que se le asigna el trabajo. Se asigna en el momento de abrir la orden de Trabajo
     */
    private Mecanico mecanico;
    /**
     * Fecha de ingreso del veh�culo y momento en que se abre el trabajo (No la Orden de Trabajo)
     */
    private final Fecha fechaIngreso;
    /**
     * Fecha en que se finaliza el trabajo
     */
    private Fecha fechaSalida;
    /**
     * Documento que se confecciona al entrar en veh�culo en el Taller
     */
    private ParteEntrada parteEntrada;
    /**
     * estado en que se encuentra el Trabajo. (ESPERA - estado inicial, ABIERTA, CERRADA)
     */
    private Estado estado;
    /**
     * Documento que se abre cuando se va a acometer el trabajo. Puede no llegar a hacerse si se anula el trabajo
     */
    private OrdenDeTrabajo ot;
    /**
     * Documento que se realiza cuando el finaliza el trabajo
     */
    private ParteSalida parteSalida;

    /**
     * Constructor parametrizado con los datos necesarios para iniciar el Trabajo. Cuando se crea un Trabajo
     * (Constructor), se debe crear un Parte de entrada
     * @param vehiculo Veh�culo sobre el que se realiza el trabajo
     * @param motivo Motivo del trabajo que coincidir� con el motivo del ingreso
     * @param fechaIngreso Fecha de ingreso del veh�culo y momento en que se abre el trabajo (No la Orden de Trabajo)
     */
    public Trabajo(Vehiculo vehiculo, String motivo, Fecha fechaIngreso) {
        this.vehiculo = vehiculo;
        this.motivo = motivo;
        this.fechaIngreso = fechaIngreso;
        crearParteEntrada();
        estado = Estado.ESPERA;
    }


    /**
     * M�todo que crea un Parte de Entrada
     */
    private void crearParteEntrada(){
        parteEntrada = new ParteEntrada(this);
    }


    /**
     * Setter de parteSalida
     * @param parteSalida del tipo documentacion.ParteSalida
     */
    public void setParteSalida(ParteSalida parteSalida) {
        this.parteSalida = parteSalida;
    }

    /**
     * Setter de fechaSalida
     * @param fechaSalida del tipo fecha.Fecha
     */
    public void setFechaSalida(Fecha fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Getter de ot
     * @return ot
     */
    public OrdenDeTrabajo getOt() {
        return ot;
    }

    /**
     * Setter de estado
     * @param estado del tipo taller.Estado
     */
    private void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Setter de mecanico. Al asignar el mec�nico a la OT se debe, asimismo, asignar la OT al mec�nico
     * @param mecanico del tipo personal.Mecanico
     */
    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    /**
     * Getter de mecanico
     * @return mecanico
     */
    public Mecanico getMecanico() {
        return mecanico;
    }

    /**
     * Getter de parteEntrada
     * @return parteEntrada
     */
    public ParteEntrada getParteEntrada() {
        return parteEntrada;
    }

    /**
     * Getter de estado
     * @return estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Getter de vehiculo
     * @return vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Getter de motivo
     * @return motivo
     */
    private String getMotivo() {
        return motivo;
    }

    /**
     * Getter de fechaIngreso
     * @return fechaIngreso
     */
    private Fecha getFechaIngreso() {
        return fechaIngreso;
    }


    /**
     * Setter de ot
     * @param ot del tipo taller.OT
     */
    private void setOt(OrdenDeTrabajo ot) {
        this.ot = ot;
    }

    /**
     * Texto con informaci�n gen�rica del trabajo a reaizar
     * @return Cadena de Texto
     */
    @Override
    public String toString() {
        return  "Fecha Ingreso: " + getFechaIngreso() +  "\n" +
                "Veh�culo: " + getVehiculo() + "\n" +
                "Cliente: " + getVehiculo().getPropietario() + "\n" +
                "Motivo Ingreso: " + getMotivo() + "\n";
    }


    /**
     * Cierra una OT.
     * Se cambia el estado a CERRADA
     * Se asigna la fecha de Salida del veh�culo
     * Se crea un Parte de Salida
     * Se actualiza el n�mero de �rdenes abiertas de mec�nico asignado
     * @param e EventWorkShop
     */
    @Override
    public void onCloseOT(EventWorkShop e) {
        if (estado == Estado.ABIERTA) {
            // Cambiar estado
            setEstado(Estado.CERRADA);
            // Asignar la fecha de salida
            setFechaSalida(new Fecha());
            // Crear parte de Salida
            setParteSalida(new ParteSalida(this));
        }
    }


    /**
     * Abre una OT (Orden de Trabajo). Al abrir la OT se le asigna un mec�nico, se cambia el estado del Trabajo
     * y se asigna la Ot al atributo de la Clase
     * @param e EventWorkShop
     */
    @Override
    public void onInitOT(EventWorkShop e) {
        if (Estado.ESPERA == estado) {
            // Cambiar estado
            setEstado(Estado.ABIERTA);
            // Crear y asignar OT
            setOt(new OrdenDeTrabajo(this));
        }
    }
}
