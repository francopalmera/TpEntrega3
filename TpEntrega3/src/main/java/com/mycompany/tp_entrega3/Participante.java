package com.mycompany.tp_entrega3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Franco
 */



public class Participante {
    private int idParticipante;
    private String nombre;
    private ListaPronosticos pronosticos;

    public Participante(int idParticipante, String nombre) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.pronosticos = new ListaPronosticos();
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaPronosticos getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(ListaPronosticos pronosticos) {
        this.pronosticos = pronosticos;
    }

    public void cargarPronosticos() {
        pronosticos.cargarDeArchivo();
    }

    public int getPuntaje() {
        int puntaje = 0;
        for (Pronostico pronostico : pronosticos.getPronosticos()) {
            puntaje += pronostico.puntos();
        }
        return puntaje;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "idParticipante=" + idParticipante +
                ", nombre='" + nombre + '\'' +
                ", pronosticos=" + pronosticos +
                '}';
    }
}
    

