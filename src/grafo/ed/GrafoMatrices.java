/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.uac.ed;

import java.util.ArrayList;

/**
 *
 * @author davidcerchiaro
 */
public class GrafoMatrices<V, A> implements Grafo<V, A> {

    ArrayList<V> vertices = new ArrayList<>();
    Double[][] aristas = new Double[1000][1000];

    public GrafoMatrices() {
        for (int i = 0; i < this.aristas.length; i++) {
            for (int j = 0; j < aristas.length; j++) {
                if (i != j) {
                    aristas[i][j] = 999999.0;
                } else {
                    aristas[i][j] = 0.0;

                }
            }
        }
    }

    @Override
    public void insVertice(V x) {
        vertices.add(x);
    }

    @Override
    public V obtVertice(int pos) {
        if (valida(pos)) {
            return vertices.get(pos);
        }
        return null;
    }

    @Override
    public void insArista(int vi, int vf, A cost) {
        if (valida(vi) && valida(vf)) {
            this.aristas[vi][vf] = (Double) cost;
        }
    }

    @Override
    public A costoArista(int vi, int vf) {
        if (valida(vi) && valida(vf)) {
            return (A) aristas[vi][vf];
        }
        return null;
    }

    @Override
    public int orden() {
        return vertices.size();
    }

    @Override
    public ArrayList<V> sucesores(int v) {
        ArrayList<V> suc = new ArrayList<>();
        for (int j = 0; j < orden(); j++) {
            if (aristas[v][j] != 999999.0 && v != j) {
                suc.add(this.obtVertice(j));
            }
        }
        return suc;
    }

    private boolean valida(int pos) {
        return orden() > pos;
    }

    @Override
    public String toString() {
        String mostrar = "";
        mostrar += "Vertices " + vertices.toString() + "\n";
        for (int i = 0; i < orden(); i++) {
            for (int j = 0; j < orden(); j++) {
                mostrar += " " + this.aristas[i][j];
            }
            mostrar += "\n";
        }
        return mostrar;
    }

}
