/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.estructuras;

/**
 *
 * @author davidcerchiaro
 */
public class Nodo<E>  {
    public E dato;
    public Nodo<E> sig;

    public Nodo(E dato) {
        this.dato = dato;
    }

    
}
