/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prac3pcd;

import java.util.*;

/**
 *
 * @author Don Daniel
 */
public class UsaCola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      ColaLenta cola = new ColaLenta(10);
        Producto p = new Producto(cola);
        Consumidor c = new Consumidor(cola);
        
        Thread c1 = new Thread(c);
        Thread c2 = new Thread(c);
        
        p.start();
        try {
            p.join();
        } catch (Exception e) {
            System.out.println("Excepcion :"+e);
        }
        
        c1.start();
        c2.start();
        try {
            c1.join();
            c2.join();
        } catch (Exception e) {
            System.out.println("Excepcion: "+e);}
        
        
    
        
        
    }
      
      
}