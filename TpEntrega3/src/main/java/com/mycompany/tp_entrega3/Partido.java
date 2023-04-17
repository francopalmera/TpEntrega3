/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_entrega3;

/**
 *
 * @author Franco
 */

public class Partido {
    private int idPartido;
    private int idEquipo1;
    private int idEquipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    
    
    public Partido(int idPartido, int idEquipo1, int idEquipo2, int golesEquipo1, int golesEquipo2) {
        this.idPartido = idPartido;
        this.idEquipo1 = idEquipo1;
        this.idEquipo2 = idEquipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }
    
    public Partido() {
        this.idEquipo1 = idEquipo1;
        this.idEquipo2 = idEquipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }
    
    public int getIdPartido(){
        return idPartido;
    }
    
    public void setIdPartido(int idPartido){
        this.idPartido = idPartido;
    }

    public int getIdEquipo1() {
        return idEquipo1;
    }

    public void setIdEquipo1(int idEquipo1) {
        this.idEquipo1 = idEquipo1;
    }

    public int getIdEquipo2() {
        return idEquipo2;
    }

    public void setIdEquipo2(int idEquipo2) {
        this.idEquipo2 = idEquipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }
    
    public String toString() {
        String res = 
                "-----------------------------------------\n"+
                this.idEquipo1 +" vs. "+this.idEquipo2+"\n"+
                "Resultado: "+this.golesEquipo1+ " a "+this.golesEquipo2+"\n"+
                "-----------------------------------------\n";
                
        return res;
    }
    
      public String resultado(Equipo equipo) {
        if (equipo.getIdEquipo() == idEquipo1 && golesEquipo1 > golesEquipo2) {
            return "G";
        } else if (equipo.getIdEquipo() == idEquipo2 && golesEquipo2 > golesEquipo1) {
            return "G";
        } else if (golesEquipo1 == golesEquipo2) {
            return "E";
        } else {
            return "P";
        }
    }
}
