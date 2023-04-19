/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_entrega3;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Franco
 */
public class ListaPronosticos {

    // atributo
    private List<Pronostico> pronosticos;
    private String pronosticosCSV;

    public ListaPronosticos(List<Pronostico> pronosticos, String pronosticosCSV) {
        this.pronosticos = pronosticos;
        this.pronosticosCSV = pronosticosCSV;
    }

    public ListaPronosticos() {
        this.pronosticos = new ArrayList<Pronostico>();
        this.pronosticosCSV = "pronosticos.csv";
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public String getPronosticosCSV() {
        return pronosticosCSV;
    }

    public void setPronosticosCSV(String pronosticosCSV) {
        this.pronosticosCSV = pronosticosCSV;
    }

    // add y remove elementos
    public void addPronostico(Pronostico p) {
        this.pronosticos.add(p);
    }

    public void removePronostico(Pronostico p) {
        this.pronosticos.remove(p);
    }

    @Override
    public String toString() {
        return "" + pronosticos ;
    }

    public String listar() {
        String lista = "";
        for (Pronostico pronostico : pronosticos) {
            lista += "\n" + pronostico;
        }
        return lista;
    }

    // Cargar desde el archivo, filtrando solamente aquellos pronósticos
    // cuyo idParticipante coincide con el indicado
    // De esa forma todos los pronósticos de la lista pertenecen al mismo participante.
    public void cargarDeArchivo(
            int idParticipante, // id del participante que realizó el pronóstico
            ListaEquipos listaequipos, // lista de equipos
            ListaPartidos listapartidos // lista de partidos
    ) {
        

        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:sqlite:pronosticos.db");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pronosticos");

            while (rs.next()) {
                
                // graba el equipo en memoria
                //convertir un string a un entero;
                int readidPronostico = rs.getInt("idPronostico");
                int readidParticipante = rs.getInt("idParticipante");
                int readidPartido = rs.getInt("idPartido");
                int readidEquipo = rs.getInt("idEquipo");
                char readResultado = rs.getString("resultado").charAt(0);     // El primer caracter es una comilla delimitadora de campo
                // Si coincide el idParticipante con el que estoy queriendo cargar,
                // sigo, si no, salteo el registro y voy al siguiente
                if (readidParticipante == idParticipante) {
                    // Obtener los objetos que necesito para el constructor
                    Partido partido = listapartidos.getPartido(readidPartido);
                    Equipo equipo = listaequipos.getEquipo(readidEquipo);
                    // crea el objeto en memoria
                    Pronostico pronostico = new Pronostico(
                            readidPronostico, // El id leido del archivo
                            equipo, // El Equipo que obtuvimos de la lista
                            partido, // El Partido que obtuvimos de la lista
                            readResultado // El resultado que leimos del archivo
                            
                    );

                    // llama al metodo add para grabar el equipo en la lista en memoria
                    this.addPronostico(pronostico);
                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
        
    public void cargarDeArchivoTodos(
            ListaEquipos listaequipos, // lista de equipos
            ListaPartidos listapartidos // lista de partidos
    ) {
        
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc.sqlite:pronosticos.db");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pronosticos");
        
            while (rs.next()) {
                
                // graba el equipo en memoria
                //convertir un string a un entero;
                int readidPronostico = rs.getInt("idPronostico");
                int readidParticipante = rs.getInt("idParticipante");
                int readidPartido = rs.getInt("idPartido");
                int readidEquipo = rs.getInt("idEquipo");
                char readResultado = rs.getString("resultado").charAt(1);     // El primer caracter es una comilla delimitadora de campo
                
                // Obtener los objetos que necesito para el constructor
                Partido partido = listapartidos.getPartido(readidPartido);
                Equipo equipo = listaequipos.getEquipo(readidEquipo);
                // crea el objeto en memoria
                Pronostico pronostico = new Pronostico(
                        readidPronostico, // El id leido del archivo
                        equipo, // El Equipo que obtuvimos de la lista
                        partido, // El Partido que obtuvimos de la lista
                        readResultado, // El resultado que leimos del archivo,
                        readidParticipante
                );

                // llama al metodo add para grabar el equipo en la lista en memoria
                this.addPronostico(pronostico);

            }
            con.close();
            //closes the scanner
        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
        }   
    }
}

