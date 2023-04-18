/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_entrega3;

import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ANITA
 */
public class PronosticoDeportivo {
    private ListaEquipos equipos;
    private ListaPartidos partidos;
    private ListaParticipantes participantes;
    private ListaPronosticos pronosticos;

    public PronosticoDeportivo() {
        equipos = new ListaEquipos();
        partidos = new ListaPartidos();
        participantes = new ListaParticipantes();
        pronosticos = new ListaPronosticos();
    }

    public void play(){
        // cargar y listar los equipos  
        equipos.cargarDeArchivo();
        //System.out.println("Los equipos cargados son: " + equipos.listar());
        
        partidos.cargarDeArchivo(equipos);
       // System.out.println("Los partidos cargados son: " + partidos.listar());

        participantes.cargarDeArchivo();
        // Una vez cargados los participantes, para cada uno de ellos
        // cargar sus pronósticos
        for (Participante p : participantes.getParticipantes()) {
            p.cargarPronosticos(equipos, partidos);
        }
        
        System.out.println(" " + participantes.listar());
        
        Collections.sort(participantes.getParticipantes(), new Comparator<Participante>() {
            @Override
            public int compare(Participante p1, Participante p2) {
                return p2.getPuntaje() - p1.getPuntaje();
            }
        });
        System.out.println("\n \n Ranking:");
        for (int i = 0; i < participantes.getParticipantes().size(); i++) {
            Participante p = participantes.getParticipantes().get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + ": " + p.getPuntaje() + " puntos");
        }
        System.out.println("\n \n \n");
        System.out.println("EL GANADOR ES: " + participantes.getParticipantes().get(0).getNombre());
    }
        
        
        
    }    
}
