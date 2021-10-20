/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.estructuras;

import datos.Util.ListaSimple;

/**
 *
 * @author davidcerchiaro
 */
public class ListaCircular<E> implements ListaSimple<E> {

    private Nodo<E> cursor = null;
    private int cantidad = 0;

    @Override
    public void insertarFin(E x) {
        Nodo<E> nuevo = new Nodo<>(x);
        this.cantidad++;
        if (vacia()) {
            cursor = nuevo;
        } else {
            Nodo<E> p = cursor;
            do {
                p = p.sig;
            } while (p.sig != cursor);
            p.sig = nuevo;
        }
        nuevo.sig = cursor;
    }

    @Override
    public void insertarInicio(E x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPos(int pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarFin() {
        if (!vacia()) {
            this.cantidad();
            if (cursor.sig == cursor) { //cuando hay un solo elemento en la lista!
                cursor = null;
            } else {
                Nodo<E> p = cursor;
                Nodo<E> q = p;
                do {
                    q = p;
                    p = p.sig;
                } while (p.sig != cursor);
                p=null;
                q.sig=cursor;
            }
        }
    }

    @Override
    public void eliminarInicio() { //elimina la primera posicion de la lista
        if (!vacia()) {
            this.cantidad--;
            if (cursor.sig == cursor) {
                cursor = null;
            } else {
                Nodo<E> p = cursor;
                do {
                    p = p.sig;
                } while (p.sig != cursor);
                cursor = cursor.sig;
                p.sig = cursor;
            }
        }
    }

    @Override
    public boolean buscar(E x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantidad() {
        return this.cantidad;
    }

    @Override
    public String mostrar() {
        if (!vacia()) {
            String list = "";
            Nodo<E> p = cursor;
            do {
                list += " " + p.dato.toString() + "\n";
                p = p.sig;
            } while (p != cursor);
            return list;
        }
        return "";
    }

    @Override
    public E obtener(int pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean vacia() {
        return (cursor == null); //retorna 0 o 1
    }

}
