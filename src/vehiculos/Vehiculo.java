package vehiculos;

import fecha.Fecha;
import interfaces.Revisable;
import persona.Persona;
import taller.Revision;

import java.io.Serializable;

/**
 * Clase abstracta que modela un veh�culo gen�rico
 * Imlementa la interfaz Revisable de modo que todas las subclases son Revisables
 * As� mismo implementa la interface Serializable para permitir su Serializaci�n
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
      * @param matricula Identificador del veh�culo
     * @param marca marca del veh�culo
     * @param modelo Modelo
     * @param kms Kil�ometros al ingresar en el talle
     */
    protected Vehiculo(String matricula, String marca, String modelo,int kms) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.kms = kms;
        estableceIntervaloKms();
    }

    /**
     * Calcula los km,s para la pr�xima revisi�n peri�dica
     * @return Entero con los Kms de le pr�xima revisi�n
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
     * @param motivo Motivo de la revisi�n
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
