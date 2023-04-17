/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_entrega3;

/**
 *
 * @author ANITA
 */


public class Pronostico {
    private int idPronostico;
    private Equipo equipo;
    private Partido partido;
    private String resultado;

    public Pronostico(int idPronostico, Equipo equipo, Partido partido, String resultado) {
        this.idPronostico = idPronostico;
        this.equipo = equipo;
        this.partido = partido;
        this.resultado = resultado;
    }

    public int puntos() {
        if (partido.resultado(equipo) == resultado) {
            return 3;
        } else if (resultado == "E" && partido.resultado(equipo) == "E") {
            return 1;
        } else {
            return 0;
        }
    }

    public int getIdPronostico() {
        return idPronostico;
    }

    public void setIdPronostico(int idPronostico) {
        this.idPronostico = idPronostico;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    
}
