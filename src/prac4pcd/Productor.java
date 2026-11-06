/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prac4pcd;

import java.util.Random;

/**
 *
 * @author Don Daniel
 */
public class Productor extends Thread{

    private ColaLenta Cola;
     private Random rnd = new Random();
     
    public Productor(ColaLenta Cola) {
        this.Cola = Cola;
    }
    
    public void producir() throws Exception{
    
        for (int i = 0; i < 15; i++) {
            Thread.sleep(1000 + rnd.nextInt(2001));
            float numero = (float) Math.random();
            Cola.acola(numero);
            System.out.println("Identificador: "+ this.getName() + " Número: " + numero);
        }
    }
    
    
    @Override
    public void run(){
        try {
            producir();
        } catch (Exception e) {
            System.out.println("Excepcion: "+ e);}
        }
}

