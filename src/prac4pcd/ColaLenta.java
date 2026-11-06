/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prac4pcd;

/**
 *
 * @author Don Daniel
 */
public class ColaLenta implements Icola {

    private int capacidad;
    private int numelementos;
    private int tail;
    private int head;
    private int extraidos;
    private Object[] datos;
    private CanvasCola canvas;

    public ColaLenta(int capacidad2) {

        this.capacidad = capacidad2;
        this.numelementos = 0;
        this.tail = 0;
        this.head = 0;
        this.datos = new Object[capacidad];
        this.extraidos = 0;
    }

    public boolean estaLlena() {
        return (numelementos == capacidad);
    }

    public boolean estaVacia() {
        return (numelementos == 0);
    }

    //Constructor que inicializa un canvas en cola lenta
    public ColaLenta(int capacidad2, CanvasCola canvas) {
        this.canvas = canvas;
        this.capacidad = capacidad2;
        this.numelementos = 0;
        this.tail = 0;
        this.head = 0;
        this.datos = new Object[capacidad];
    }

    public int getNum() {
        return numelementos;
    }

    public synchronized void acola(Object elemento) throws Exception {
        int intentos = 0;

        while (estaLlena()) {
            if (extraidos == 15 || intentos == 3) {
                canvas.avisa("INTENTOS GASTADOS DE " + Thread.currentThread().getName() + " O EXTRAIDOS = 15");
                throw new Exception("Intentos gastados.");
            }
            System.out.println(Thread.currentThread().getName() + " espera hueco (intento " + intentos + " )");
            wait();
            intentos++;
        }
        if (extraidos == 15) {
            canvas.avisa(Thread.currentThread().getName() + " termina: el consumidor ya acabó");
            throw new Exception("El consumidor ha terminado.");
        }
        datos[tail] = elemento;
        tail = (tail + 1) % capacidad;
        numelementos++;
        canvas.representa(datos, head, tail, numelementos);
        //cada vez que acolo actualizo el canvas
        notifyAll();
    }

    public synchronized Object desacola() throws Exception {
        int intentos2 = 0;
        while (estaVacia()) {
            if (intentos2 == 3) {
                canvas.avisa("El hilo: " + Thread.currentThread().getName() + " ha alcanzado el numero maximo de intentos.");
                throw new Exception("El hilo: " + Thread.currentThread().getName() + " ha alcanzado el numero maximo de intentos.");
            }
            System.out.println(Thread.currentThread().getName() + " espera elemento (intento " + intentos2 + " )");
            wait();
            intentos2++;

        }
        Object ElementoExtraido = datos[head];
        head = (head + 1) % capacidad;
        numelementos--;
        canvas.representa(datos, head, tail, numelementos);
        extraidos++;
        notifyAll();
        return ElementoExtraido;

    }

    public Object primero() throws Exception {
        if (numelementos == 0) {
            throw new Exception("La cola esta vacia.");
        } else {
            Object ElementoExtraido = datos[head];
            return ElementoExtraido;
        }
    }

}
