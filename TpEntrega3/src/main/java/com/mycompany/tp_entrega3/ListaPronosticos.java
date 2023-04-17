/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_entrega3;

/**
 *
 * @author ANITA
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;


public class ListaPronosticos {
    private ArrayList<Pronostico> pronosticos;
    
    public ListaPronosticos() {
        pronosticos = new ArrayList<>();
    }
    
    public ArrayList<Pronostico> getPronosticos() {
        return pronosticos;
    }
    
    public void setPronosticos(ArrayList<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }
    
    public void agregarPronostico(Pronostico p) {
        pronosticos.add(p);
    }
    
    public void cargarDeArchivo() {
 
    try {
        
        ListaParticipantes participantes = new ListaParticipantes();
        ListaPartidos partidos = new ListaPartidos();
        ListaEquipos equipos = new ListaEquipos();
        Connection con = DriverManager.getConnection("jdbc:sqlite:pronosticos.db");
        Statement consulta = con.createStatement();
        ResultSet rs = consulta.executeQuery("SELECT * FROM pronosticos");

        while (rs.next()) {
            int idPronostico = rs.getInt("idPronostico");
            int idParticipante = rs.getInt("idParticipante");
            int idPartido = rs.getInt("idPartido");
            int idEquipo = rs.getInt("idEquipo");
            String resultado = rs.getString("resultado");

            // Buscamos el participante correspondiente
            Participante participante = null;
            for (Participante p : participantes.getParticipantes()) {
                if (p.getIdParticipante() == idParticipante) {
                    participante = p;
                    break;
                }
            }

            // Buscamos el partido correspondiente
            Partido partido = null;
            for (Partido p : partidos.getPartidos()) {
                if (p.getIdPartido() == idPartido) {
                    partido = p;
                    break;
                }
            }

            // Buscamos el equipo correspondiente
            Equipo equipo = null;
            for (Equipo e : equipos.getEquipos()) {
                if (e.getIdEquipo() == idEquipo) {
                    equipo = e;
                    break;
                }
            }

            // Creamos el pronóstico y lo agregamos a la lista
            Pronostico pronostico = new Pronostico(idPronostico, equipo, partido, resultado);
            pronosticos.add(pronostico);
        }

        
        con.close();
    } catch (SQLException e) {
        System.out.println("Error al cargar los pronósticos: " + e.getMessage());
    }
}


    
    public int getPuntaje() {
        int puntajeTotal = 0;
        for (Pronostico p : pronosticos) {
            puntajeTotal += p.puntos();
        }
        return puntajeTotal;
    }
    
    @Override
    public String toString() {
        String s = "";
        for (Pronostico p : pronosticos) {
            s += p.toString() + "\n";
        }
        return s;
    }
}

    
   

   


    
    
