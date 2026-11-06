/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prac3pcd;

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
    private CanvasCola canvas;
    
    public ColaLenta(int capacidad2){
        
        this.capacidad=capacidad2;
        this.numelementos=0;
    this.tail=0;
    this.head=0;
    this.datos = new Object[capacidad];}
    //Constructor que inicializa un canvas en cola lenta
    public ColaLenta(int capacidad2,CanvasCola canvas){
        this.canvas=canvas;
        this.capacidad=capacidad2;
        this.numelementos=0;
    this.tail=0;
    this.head=0;
    this.datos = new Object[capacidad];}
    
    public int getNum(){
    return numelementos;
    }
    
    
    
    public synchronized void acola (Object elemento) throws Exception{
        Thread.sleep(1000);
    if (numelementos!=capacidad){
    datos[tail]=elemento;
    tail=(tail+1)%capacidad;
    numelementos++;
    canvas.representa(datos, head, tail, numelementos);} //cada vez que acolo actualizo el canvas
    else {
        canvas.avisa("LA COLA ESTA LLENA.");
        throw new Exception("La cola esta llena.");}
    }
    
   public synchronized Object desacola() throws Exception{
       Thread.sleep(1000);
       if(numelementos==0){
           canvas.avisa("LA COLA ESTA VACIA. ");
        throw new Exception("La cola esta vacia.");}else{
           Object ElementoExtraido = datos[head];
           head=(head+1)%capacidad;
           numelementos--;
           canvas.representa(datos, head, tail, numelementos);
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
