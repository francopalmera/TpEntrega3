/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_entrega3;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Franco
 */
public class ListaPartidos {
    private List<Partido> partidos;
    private String partidodb;

    public ListaPartidos(List<Partido> partidos, String partidodb) {
        this.partidos = partidos;
        this.partidodb = partidodb;
    }

    public ListaPartidos() {
        this.partidos = new ArrayList<Partido>();
        this.partidodb = null;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public String getPartidodb() {
        return partidodb;
    }

    public void setPartidodb(String partidodb) {
        this.partidodb = partidodb;
    }
    
    public Partido getPartido (int idPartido) {
        // Defini un objeto de tipo Participante en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el equipo que 
        // buscaba todavía.
        Partido encontrado = null;
        // Recorro la lista de participantes que está cargada
        for (Partido eq : this.getPartidos()) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (eq.getIdPartido() == idPartido) {
                // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                encontrado = eq;
                // Y hago un break para salir del ciclo ya que no hace falta seguir buscando
                break;
            }
        }
        // Una vez fuera del ciclo retorno el Participante, pueden pasar dos cosas:
        // 1- Lo encontré en el ciclo, entonces encontrado tiene el objeto encontrado
        // 2- No lo encontré en el ciclo, entonces conserva el valor null del principio
        return encontrado;
    }

    @Override
    public String toString() {
        return "";
    }
    
    public String listar() {
        String lista = "";
        for (Partido partido: partidos) {
            lista += "\n" + partido;
        }           
        return lista;
    }
    
    public void cargarDeArchivo(ListaEquipos listaequipos){
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:sqlite:pronosticos.db");
            Statement stmt = con.createStatement();
            String sql = "SELECT idPartido, idEquipo1, idEquipo2, golesEquipo1, golesEquipo2 FROM partidos";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                Integer idPartido = rs.getInt("idPartido");
                Integer readidEquipo1 = rs.getInt("idEquipo1");
                Integer readidEquipo2 = rs.getInt ("idEquipo2");
                Integer golesEquipo1 = rs.getInt("golesEquipo1");
                Integer golesEquipo2 = rs.getInt("golesEquipo2");
                
                Equipo equipo1 = listaequipos.getEquipo(readidEquipo1);
                Equipo equipo2 = listaequipos.getEquipo(readidEquipo2);
                Partido partido = new Partido(idPartido, equipo1, equipo2, golesEquipo1, golesEquipo2);
                this.partidos.add(partido);
            }
            con.close();
            
        }
        catch (SQLException e) {
            System.out.println("Error al cargar los partidos desde la base de datos: " + e.getMessage());
        }
            
    }
    
    
    
}
