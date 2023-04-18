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
    
    private Integer idPronostico;
    private Equipo equipo;
    private Partido partido;
    private char resultado;

    public Pronostico(Integer idPronostico, Equipo equipo, Partido partido, char resultado) {
        this.idPronostico = idPronostico;
        this.equipo = equipo;
        this.partido = partido;
        this.resultado = resultado;
    }

    public Pronostico(int readidPronostico, Equipo equipo1, Partido partido1, char readResultado, int readidParticipante) {
        this.idPronostico = null;
        this.equipo = null;
        this.partido = null;
        this.resultado = 0;
    }

    public Integer getIdPronostico() {
        return idPronostico;
    }

    public void setIdPronostico(Integer idPronostico) {
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

    public char getResultado() {
        return resultado;
    }

    public void setResultado(char resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        String res = "\nApuesto a que en el partido:\n"+
                this.getPartido()+
                this.getEquipo().getNombre()+" obtiene el siguiente Resultado: "+
                this.getResultado()+"\n";
        return res;
    }
    
    public int puntos() {
        if (partido.getResultado(equipo) == resultado) {
            return 3;
        } else if (resultado == 'E' && partido.getResultado(equipo) == 'E') {
            return 1;
        } else {
            return 0;
        }
    }
    
    
}
