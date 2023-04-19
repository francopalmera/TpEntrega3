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
public class ListaEquipos {
    private List<Equipo> equipos;
    private String equiposDB;

    public ListaEquipos(ArrayList<Equipo> equipos, String equiposDB) {
        this.equipos = equipos;
        this.equiposDB = equiposDB;
    }

    public ListaEquipos() {
        this.equipos = new ArrayList<Equipo>();
        this.equiposDB = null;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public String getEquiposDB() {
        return equiposDB;
    }

    public void setEquiposDB(String equiposDB) {
        this.equiposDB = equiposDB;
    }
    
    /***
     * Este método devuelve un Participante (o null) buscandolo por idParticipante
     * @param idEquipo Identificador del equipo deseado
     * @return Objeto Equipo (o null si no se encuentra)
     */
    public Equipo getEquipo (int idEquipo) {
        // Defini un objeto de tipo Participante en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el equipo que 
        // buscaba todavía.
        Equipo encontrado = null;
        // Recorro la lista de participantes que está cargada
        for (Equipo eq : this.getEquipos()) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (eq.getIdEquipo() == idEquipo) {
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

    /*@Override
    public String toString() {
        return "ListaEquipos{" + "equipos=" + equipos + ", equiposDB=" + equiposDB + '}';
    }*/
    
    public String listar() {
        String lista = "";
        for (Equipo equipo: equipos) {
            lista += "\n" + equipo;
        }           
        return lista;
    }
    
    public void cargarDeArchivo(){
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:sqlite:pronosticos.db");
            Statement stmt = con.createStatement();
            String sql = "SELECT idEquipo, nombre, descripcion FROM equipos";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                int idEquipo = rs.getInt("idEquipo");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                
                Equipo equipo = new Equipo(idEquipo, nombre, descripcion);
                this.equipos.add(equipo);
            }
            con.close();
        }   catch (SQLException e) {
                System.out.println("Error al cargar los equipos desde la base de datos: " + e.getMessage());
                }    
        }
    
        
    }

