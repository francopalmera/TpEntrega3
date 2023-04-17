
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 *
 * @author
 */


public class PronosticoDeportivo {

private ListaParticipantes participantes;
private ListaPartidos partidos;

public PronosticoDeportivo() {
    participantes = new ListaParticipantes();
    partidos = new ListaPartidos();
}

public void play() {
    // Cargar participantes y partidos desde archivos
    participantes.cargarDeArchivo();
    partidos.cargarDeArchivo();
    
    // Cargar pronósticos de cada participante desde archivo
    for (Participante p : participantes.getParticipantes()) {
        p.cargarPronosticos();
    }
    
    // Calcular puntajes para cada pronóstico
    for (Pronostico pr : getAllPronosticos()) {
        pr.puntos();
    }
    
    // Ordenar participantes por puntaje
    //Collections.sort(participantes.getParticipantes());
    
    // Mostrar listado de participantes y puntajes
    for (Participante p : participantes.getParticipantes()) {
        System.out.println(p.getNombre() + " - " + p.getPuntaje() + " puntos");
    }
    
    // Mostrar al ganador
    System.out.println("El ganador es " + participantes.getParticipantes().get(0).getNombre());
}

private ArrayList<Pronostico> getAllPronosticos() {
    ArrayList<Pronostico> allPronosticos = new ArrayList<>();
    for (Participante p : participantes.getParticipantes()) {
        allPronosticos.addAll(p.getPronosticos().getPronosticos());
    }
    return allPronosticos;
}
}