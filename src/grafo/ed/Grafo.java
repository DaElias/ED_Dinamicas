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
public interface Grafo<V, A> {

    void insVertice(V x);

    V obtVertice(int pos);

    void insArista(int vi, int vf, A cost);
    
    A costoArista(int vi, int vf);
    
    int orden();
    
    @Override
    String toString();
    
    ArrayList<V> sucesores(int v);
    
    
}
