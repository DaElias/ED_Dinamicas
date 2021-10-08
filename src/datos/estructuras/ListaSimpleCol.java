/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.estructuras;

import datos.Util.ListaSimple;
import java.util.LinkedList;

/**
 *
 * @author davidcerchiaro
 */
public class ListaSimpleCol<E> implements ListaSimple<E> {

    private LinkedList<E> lista;

    public ListaSimpleCol() {
        this.lista = new LinkedList<>();
    }

    @Override
    public void insertarFin(E x) {
        this.lista.addLast(x);
    }

    @Override
    public void insertarInicio(E x) {
        this.lista.addFirst(x);
    }

    @Override
    public void eliminarFin() {
        this.lista.removeLast();
    }

    @Override
    public void eliminarInicio() {
        this.lista.removeFirst();
    }

    @Override
    public int cantidad() {
        return this.lista.size();
    }

    @Override
    public String mostrar() {
        String list="";
        for (E e : lista) {
            list+=" "+e.toString()+"\n";
        }
        
        return list;
    }

    @Override
    public E obtener(int pos) {
        return this.lista.get(pos);
    }

    @Override
    public boolean vacia() {
        return this.lista.isEmpty();
    }

    @Override
    public boolean buscar(E x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPos(int pos) {
        this.lista.remove(pos);
    }

}
