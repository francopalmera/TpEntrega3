/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tp_entrega3;

/**
 *
 * @author Franco
 */

public class TpEntrega3 {

    public static PronosticoDeportivo PRODE;
    
    //La base de datos pronosticos.db fue modificada.
   
    public static void main(String[] args) {
        System.out.println ("Sistema de simulación de pronósticos deportivos.");
        System.out.println ("Ejecutándose desde:"+System.getProperty("user.dir"));
        
        PRODE = new PronosticoDeportivo();

        PRODE.play();
    }
    
}
