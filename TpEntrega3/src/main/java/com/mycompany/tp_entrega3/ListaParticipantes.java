/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_entrega3;

/**
 *
 * @author Franco
 */

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ListaParticipantes {
    //atributos
    private List<Participante> participante;
    private String pronosticosDB;
    
    public ListaParticipantes(List<Participante> participante, String pronosticosDB) {
        this.participante = participante;
        this.pronosticosDB = pronosticosDB;
    }
    
        public ListaParticipantes() {
        this.participante = new ArrayList<Participante>();
        this.pronosticosDB = "pronosticos.db";
    }

    public List<Participante> getParticipantes() {
        return this.participante;
    }
    
    public void setParticipantes(ArrayList<Participante> participantes){
        this.participante = participantes;
    }
    
        public String getPronosticosDB() {
        return pronosticosDB;
    }

    public void setPronosticosDB(String pronosticosDB) {
        this.pronosticosDB = pronosticosDB;
    }

    
    public void addParticipante(Participante e) {
        this.participante.add(e);
    }
    public void removeEquipo(Equipo e) {
        this.participante.remove(e);
    }
    
    /*public Participante getParticipante (int idParticipante){
        Participante encontrado = null;
        for (Participante eq : this.getParticipantes()) {
            if (eq.getIdParticipante() == idParticipante){
                encontrado = eq;
                
                break;
            }
        }
        return encontrado;
    }*/

    @Override
    public String toString() {
        return "ListaParticipantes{" + "participante=" + participante + '}';
    }

    public String listar() {
        String lista = "";
        for (Participante participante: participante) {
            lista += "\n" + participante;
        }           
        return lista;
    }
    
    // cargar desde el archivo
    public void cargarDeArchivo()  {
              
        
        try { 
            Connection con = DriverManager.getConnection("jdbc:sqlite:pronosticos.db");  
            Statement stmt = con.createStatement();
            
            String sql = "SELECT idParticipante, nombre FROM participantes";
            
            ResultSet rs = stmt.executeQuery(sql);  
 
            
            while (rs.next()) {
                
                Participante p = new Participante(
                        rs.getInt("idParticipante"),
                        rs.getString("nombre")
                        
                );
                this.addParticipante(p);
                
            }
            con.close();
            
        } catch (SQLException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }

    }
    
    public void calcularPuntajes() {
        for (Participante participante : participante) {
            participante.cargarPronosticos();
        }
    }  

}
    

