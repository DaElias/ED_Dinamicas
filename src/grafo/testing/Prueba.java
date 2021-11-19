/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.uac.testing;

import data.uac.ed.Grafo;
import data.uac.ed.GrafoMatrices;

/**
 *
 * @author davidcerchiaro
 */
public class Prueba {

    public Grafo<Integer, Double> crear() {
        Grafo<Integer, Double> grafo = new GrafoMatrices<>();
        for (int i = 1; i <= 5; i++) {
            grafo.insVertice(i);
        }

        grafo.insArista(0, 1, 60.0);
        grafo.insArista(0, 2, 100.0);
        grafo.insArista(0, 3, 10.0);
        grafo.insArista(1, 4, 8.0);
        grafo.insArista(2, 1, 40.0);
        grafo.insArista(2, 3, 30.0);
        grafo.insArista(3, 4, 20.0);
        grafo.insArista(4, 2, 5.0);
        return grafo;
    }

    public static void main(String[] args) {
        Prueba ac = new Prueba();
        System.out.println(ac.crear().toString());
        
    }
}
