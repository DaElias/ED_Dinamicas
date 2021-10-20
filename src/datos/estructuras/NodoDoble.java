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
public class NodoDoble<E> {

    private E dato;
    private NodoDoble sig;
    private NodoDoble ant;

    public NodoDoble(E dato) {
        this.dato=dato;
    }

    /**
     * @return the dato
     */
    public E getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(E dato) {
        this.dato = dato;
    }

    /**
     * @return the sig
     */
    public NodoDoble getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(NodoDoble sig) {
        this.sig = sig;
    }

    /**
     * @return the ant
     */
    public NodoDoble getAnt() {
        return ant;
    }

    /**
     * @param ant the ant to set
     */
    public void setAnt(NodoDoble ant) {
        this.ant = ant;
    }

    
}
