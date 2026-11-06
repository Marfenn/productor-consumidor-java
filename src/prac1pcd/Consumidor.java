/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prac1pcd;

/**
 *
 * @author Don Daniel
 */
public class Consumidor implements Runnable{
    private ColaLenta cola;

    public Consumidor(ColaLenta cola) {
        this.cola = cola;
    }
    
    public void Consumir() throws Exception {
        for (int i = 0; i < 10; i++) {
            Object valor=cola.desacola();
            System.out.println("Identificador: " + Thread.currentThread().getName()+ "Valor= " + valor);
        }
    }
    
    @Override
    public void run(){
        try {
            Consumir();
        } catch (Exception e) {
            System.out.println("Excepcion : "+e);}
    }
}
