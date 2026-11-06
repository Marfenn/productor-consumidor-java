/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prac1pcd;

import java.util.*;

/**
 *
 * @author Don Daniel
 */
public class Prac1PCD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cola c = new Cola(4);
        int numal = 0;

        for (int i = 0; i < 10; i++) {
            try {
                Random r = new Random(System.currentTimeMillis());

                numal = r.nextInt(0,2);
                if (numal == 0) {
                    System.out.println("Desacolado: "+ c.desacola());  
                }else{
                c.acola(i);}
            } catch (Exception e) {
                System.out.println("Excepcion lanzada por: "+ e.getMessage());
            }
        }

    }
}