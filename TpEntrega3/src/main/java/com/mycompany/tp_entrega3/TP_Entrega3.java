/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.tp_entrega3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TP_Entrega3 {

    public static PronosticoDeportivo PRODE;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PRODE = new PronosticoDeportivo();
        PRODE.play();   
        
    
  }
        
        
        
    }
    

