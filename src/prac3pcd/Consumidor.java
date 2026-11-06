/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prac3pcd;

/**
 *
 * @author Don Daniel
 */
public class Consumidor extends Thread{
    private ColaLenta cola;

    public Consumidor(ColaLenta cola) {
        this.cola = cola;
    }
    /*
    public void Consumir() throws Exception {
        for (int i = 0; i < 10; i++) {
            Object valor=cola.desacola();
            System.out.println("Identificador: " + Thread.currentThread().getName()+ "Valor= " + valor);
        }
    }
    */
    
    public void consumir() throws Exception {
        int consumidos = 0;
        while (consumidos < 10) {
            try {
                Object valor = cola.desacola();
                System.out.println("Identificador: " + this.getName() + " Valor= " + valor);
                consumidos++;
                Thread.sleep(100);
            } catch (Exception e) {
                // Cola vacía: esperamos un poco y volvemos a intentarlo
                Thread.sleep(500);
            }
        }
    }
    
    
    @Override
    public void run(){
        try {
            consumir();
        } catch (Exception e) {
            System.out.println("Excepcion : "+e);}
    }
}
