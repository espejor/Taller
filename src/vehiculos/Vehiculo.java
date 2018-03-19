package vehiculos;

import fecha.Fecha;
import interfaces.Revisable;
import persona.Persona;
import taller.Revision;

import java.io.Serializable;

/**
 * Clase abstracta que modela un vehículo genérico
 * Imlementa la interfaz Revisable de modo que todas las subclases son Revisables
 * Así mismo implementa la interface Serializable para permitir su Serialización
 * Sus atributos son los datos que se requieren para su ingreso en el Taller
 */
public abstract class Vehiculo implements Revisable,Serializable {
    private final String matricula;
    private final String marca;
    private final String modelo;
    private Persona propietario;
    private int kms;
    protected int intervaloKms;

    /**
     * Constructor parametrizado para uso interno de las subclases
      * @param matricula Identificador del vehículo
     * @param marca marca del vehículo
     * @param modelo Modelo
     * @param kms Kilçometros al ingresar en el talle
     */
    protected Vehiculo(String matricula, String marca, String modelo,int kms) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.kms = kms;
        estableceIntervaloKms();
    }

    /**
     * Calcula los km,s para la próxima revisión periódica
     * @return Entero con los Kms de le próxima revisión
     */
    @Override
    public int proximaRevision() {
        return intervaloKms + kms;
    }

    /**
     * Setter de propietario
     * @param propietario del tipo persona.Persona
     */
    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    /**
     * Getter de matricula
     * @return matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Getter de marca
     * @return marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Getter de modelo
     * @return modelo
     */
    public String getModelo() {
        return modelo;
    }


    /**
     * Getter de propietario
     * @return propietario
     */
    public Persona getPropietario() {
        return propietario;
    }

    /**
     * @param motivo Motivo de la revisión
     * @param fecha  Fecha de apertura del trabajo
     * @return La nueva Revision abierta
     */
    @Override
    public Revision abrirRevision(String motivo, Fecha fecha) {
        return new Revision(this,motivo,fecha);
    }

    @Override
    public String toString() {
        return marca + " " + modelo + ": " + matricula;
    }

    public int getKms() {
        return kms;
    }

}
