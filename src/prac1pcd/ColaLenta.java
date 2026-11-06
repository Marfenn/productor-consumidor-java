/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prac1pcd;

/**
 *
 * @author Don Daniel
 */
public class ColaLenta implements Icola {
    private int capacidad;
    private int numelementos;
    private int tail;
    private int head;
    private Object[] datos;
    
    public ColaLenta(int capacidad2){
        
        this.capacidad=capacidad2;
        this.numelementos=0;
    this.tail=0;
    this.head=0;
    this.datos = new Object[capacidad];}
    
    public int getNum(){
    return numelementos;
    }
    
    public void acola (Object elemento) throws Exception{
        Thread.sleep(1000);
    if (numelementos!=capacidad){
    datos[tail]=elemento;
    tail=(tail+1)%capacidad;
    numelementos++;}else {
        throw new Exception("La cola esta llena.");}
    }
    
   public Object desacola() throws Exception{
       Thread.sleep(1000);
       if(numelementos==0){
        throw new Exception("La cola esta vacia.");}else{
           Object ElementoExtraido = datos[head];
           head=(head+1)%capacidad;
           numelementos--;
           return ElementoExtraido;
       }
   }
   
   
     public Object primero() throws Exception{
         if(numelementos==0){
        throw new Exception("La cola esta vacia.");}else{
           Object ElementoExtraido = datos[head];
           return ElementoExtraido;
       }
     }
    
}
