package org.example.sistemavotos.domain;

import java.io.Serializable;

public class Candidato implements Serializable {

    //propiedades de candidatos
    private int id;
    private String nombre;
    private String jornada;
    public int cantidadVotos = 0;

    //Constructores
    public Candidato() {
    }

    public Candidato(int id, String nombre, String jornada) {
        this.id = id;
        this.nombre = nombre;
        this.jornada = jornada;
    }


    //getter y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(int cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    //Método toString para una lectura legible del objeto
    @Override
    public String toString() {
        return "Candidato{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", jornada='" + jornada + '\'' +
                ", cantidadVotos=" + cantidadVotos +
                '}';
    }
}
