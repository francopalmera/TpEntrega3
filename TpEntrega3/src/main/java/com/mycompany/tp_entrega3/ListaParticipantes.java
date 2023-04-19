/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_entrega3;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Franco
 */
public class ListaParticipantes {
    // atributo
    private List<Participante> participantes;
    private String participantesCSV;

    public ListaParticipantes(List<Participante> participantes, String participantesCSV) {
        this.participantes = participantes;
        this.participantesCSV = participantesCSV;
    }
    
    public ListaParticipantes() {
        this.participantes = new ArrayList<Participante>();
        this.participantesCSV = "participantes.csv";
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public String getParticipantesCSV() {
        return participantesCSV;
    }

    public void setParticipantesCSV(String participantesCSV) {
        this.participantesCSV = participantesCSV;
    }
    
    // add y remove elementos
    public void addParticipante(Participante p) {
        this.participantes.add(p);
    }
    public void removeParticipante(Participante p) {
        this.participantes.remove(p);
    }
    
    /***
     * Este método devuelve un Participante (o null) buscandolo por idParticipante
     * @param idParticipante Identificador del equipo deseado
     * @return Objeto Participante (o null si no se encuentra)
     */
    public Participante getParticipante (int idParticipante) {
        // Defini un objeto de tipo Participante en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el equipo que 
        // buscaba todavía.
        Participante encontrado = null;
        // Recorro la lista de participantes que está cargada
        for (Participante eq : this.getParticipantes()) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (eq.getIdParticipante() == idParticipante) {
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
        return "participantes=" + participantes + '}';
    }

    public String listar() {
        String lista = "";
        for (Participante participante: participantes) {
            lista += "\n" + participante;
        }           
        return lista;
    }
    
    // cargar desde el archivo
    public void cargarDeArchivo() {
       
        try { 
            Connection con;
            con = DriverManager.getConnection("jdbc:sqlite:pronosticos.db");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM participantes");
                
            while (rs.next()) {
                             
                Integer idParticipante = rs.getInt("idParticipante");
                String nombre = rs.getString("nombre");
             
                Participante participante = new Participante(idParticipante, nombre);
                                
                this.addParticipante(participante);
            }
            
            con.close();
            
        } catch (SQLException e) {
                System.out.println("Mensaje: " + e.getMessage());
        }       
    }

}
