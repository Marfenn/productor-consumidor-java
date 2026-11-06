/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prac1pcd;

/**
 *
 * @author Don Daniel
 */
public class Producto extends Thread{

    private ColaLenta Cola;
    public Producto(ColaLenta Cola) {
        this.Cola = Cola;
    }
    
    public void producir() throws Exception{
    
        for (int i = 0; i < 10; i++) {
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

