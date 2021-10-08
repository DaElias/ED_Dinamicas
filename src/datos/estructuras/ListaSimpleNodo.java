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
public class ListaSimpleNodo<E> implements ListaSimple<E> {

    private Nodo<E> ptr;

    @Override
    public void insertarFin(E x) {
        Nodo<E> nuevo = new Nodo<>(x);
        if (vacia()) {
            this.ptr = nuevo;
        } else {
            Nodo<E> p = ptr;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = nuevo;
        }
    }

    @Override
    public void insertarInicio(E x) {
        Nodo<E> nuevo = new Nodo<>(x);
        if (vacia()) {
            ptr = nuevo;
        } else {
            nuevo.sig = ptr;
            ptr = nuevo;
        }
    }

    @Override
    public void eliminarFin() {
        if (!vacia()) {
            if (ptr.sig == null) { //cuando solo hay un valor
                ptr = null;
            } else {
                Nodo<E> p = ptr;
                Nodo<E> q = p;
                while (p.sig != null) {
                    q = p;
                    p = p.sig;
                }
                q.sig = null;
            }
        }
    }

    @Override
    public void eliminarInicio() {
        if (!vacia()) {
            Nodo<E> p = ptr;
            ptr = ptr.sig;
            p.sig = null;
        }
    }

    @Override
    public int cantidad() {
        int n = 0;
        if (!vacia()) {
            Nodo<E> p = ptr;
            while (p != null) {
                n++;
                p = p.sig;
            }
        }
        return n;
    }

    @Override
    public String mostrar() {
        String lis = "";
        if (!vacia()) {
            Nodo<E> p = ptr;
            while (p != null) {
                lis += " " + p.dato.toString() + " ";
                p = p.sig;
            }
        }
        return lis;
    }

    @Override
    public E obtener(int pos) {
        int index = 0;
        if (!vacia()) {
            Nodo<E> p = ptr;
            while (p != null) {
                if (index == pos) {
                    return p.dato;
                }
                index++;
                p = p.sig;
            }
        }
        return null;
    }

    @Override
    public boolean vacia() {
        return this.ptr == null ? true : false;
    }

    @Override
    public boolean buscar(E x) {
        if (!vacia()) {
            Nodo<E> p = ptr;
            while (p != null) {
                if (p.dato.equals(x)) {
                    return true;
                }
                p = p.sig;
            }
        }
        return false;
    }

    @Override
    public void eliminarPos(int poss) {
        if (!vacia()) {
            int index = 0;
            Nodo<E> p=ptr, q = null;
            while (p != null && poss != index) {
                index++;
                q = p;
                p = p.sig;
            }
            if (p == null) {
                System.out.println("-1");
            } else if (q == null) {
                ptr = ptr.sig;
                p = null;
            } else {
                q.sig = p.sig;
                p = null;
            }

        }
    }

}
