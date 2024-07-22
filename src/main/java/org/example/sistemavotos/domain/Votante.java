package org.example.sistemavotos.domain;

import java.io.Serializable;

public class Votante implements Serializable {

    //propiedades de votantes
    private int id;
    private String jornada;
    private boolean yaVoto = false;


    //constructor
    public Votante(int id, String jornada) {
        this.id = id;
        this.jornada = jornada;
    }

    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public boolean isYaVoto() {
        return yaVoto;
    }

    public void setYaVoto(boolean yaVoto) {
        this.yaVoto = yaVoto;
    }

    //Método toString para una lectura legible del objeto
    @Override
    public String toString() {
        return "Votante{" +
                "id='" + id + '\'' +
                ", jornada='" + jornada + '\'' +
                ", yaVoto=" + yaVoto +
                '}';
    }
}
