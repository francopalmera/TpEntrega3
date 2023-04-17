package com.mycompany.mavenproject1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

public class ListaPartidos {
    private List<Partido> partido;
    private String partidosCSV;
    
    public ListaPartidos(List<Partido> partido, String partidosCSV) {
        this.partido = partido;
        this.partidosCSV = partidosCSV;
    }

    public ListaPartidos() {
        this.partido = new ArrayList<Partido>();
        this.partidosCSV = "partidos.csv";
    }
    
        public List<Partido> getPartidos() {
        return this.partido;
    }
    
    public void setPartidos(ArrayList<Partido> partidos){
        this.partido = partidos;
    }
    
    public String getPartidosCSV() {
        return partidosCSV;
    }

    public void setPartidosCSV(String partidosCSV) {
        this.partidosCSV = partidosCSV;
    }

    
    public void addPartido(Partido e) {
        this.partido.add(e);
    }

    public void removePartido(Partido e) {
        this.partido.remove(e);
    }

    @Override
    public String toString() {
        return "ListaPartidos{" + "partido=" + partido + '}';
    }

    public String listar() {
        String lista = "";
        for (Partido partido: partido) {
            lista += "\n" + partido;
        }           
        return lista;
    }
    
        public void cargarDeArchivo()  {
              
        
        try { 
            Connection con = DriverManager.getConnection("jdbc:sqlite:pronosticos.db");  
            Statement stmt = con.createStatement();
            
            String sql = "SELECT idPartido, idEquipo1, idEquipo2, golesEquipo1, golesEquipo2 FROM partidos";
            
            ResultSet rs = stmt.executeQuery(sql);  
 
            
            while (rs.next()) {
                
                Partido p = new Partido(
                       rs.getInt("idPartido"),
                       rs.getInt("idEquipo1"),
                       rs.getInt("idEquipo2"),
                       rs.getInt("golesEquipo1"),
                       rs.getInt("golesEquipo2")
                );
                this.addPartido(p);
                                
                
            }
            con.close();
            
        } catch (SQLException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }

    }

    

}
