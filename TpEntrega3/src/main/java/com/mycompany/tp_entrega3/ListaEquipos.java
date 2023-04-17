/*
Clase ListaEquipos para la entrega 2
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaEquipos {
    private ArrayList<Equipo> equipos;
    private Connection conexion;

    public ListaEquipos() {
        equipos = new ArrayList<>();
        conexion = null;
    }

    public ListaEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
        conexion = null;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void cargarDeArchivo() {
        String url = "jdbc:sqlite:pronosticos.db";

        try {
            conexion = DriverManager.getConnection(url);
            String sql = "SELECT * FROM tablaEquipos";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int idEquipo = rs.getInt("idEquipo");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Equipo equipo = new Equipo(idEquipo, nombre, descripcion);
                equipos.add(equipo);
            }

            rs.close();
            pstmt.close();
            conexion.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        
        return null;
        
    }
}
