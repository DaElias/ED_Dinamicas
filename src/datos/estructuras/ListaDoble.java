/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.estructuras;


import datos.Util.TadListaDoble;

/**
 *
 * @author davidcerchiaro y Daniel Yepes
 * @param <E>
 */
public class ListaDoble<E> implements TadListaDoble<E> {

    NodoDoble<E> ptr, ultimo;
    private int cantidad = 0;

    @Override
    public void insertarInicio(E x) {
        NodoDoble<E> nuevo = new NodoDoble<E>(x);
        this.cantidad++;
        if (isEmpty()) {
            ptr = nuevo;
            ultimo = ptr;
        } else {
            nuevo.sig = ptr;
            ptr.ant = nuevo;
            ptr = nuevo;
        }
    }

    @Override
    public void insertarFin(E x) {
        NodoDoble<E> nuevo = new NodoDoble<E>(x);
        this.cantidad++;

        if (isEmpty()) {
            ptr = nuevo;
            ultimo = ptr;
        } else {
            nuevo.ant = ultimo;
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }
    }

    @Override
    public void eliminarInicio() {
        if (!isEmpty()) {
            this.cantidad--;

            if (ptr == ultimo) {
                ultimo = ptr = null;
            } else {
                ptr = ptr.sig;
                ptr.ant = null;
            }
        }
    }

    @Override
    public void eliminarFin() {
        if (!isEmpty()) {
            this.cantidad--;
            if (ptr == ultimo) {
                ptr = ultimo = null;
            } else {
                ultimo = ultimo.ant;
                ultimo.sig = null;
            }
        }
    }

    @Override
    public void eliminarElemento(E x) {
        if (!isEmpty()) {
            if (ptr == ultimo && ptr.dato == x) {
                ptr = ultimo = null;
            } else if (ptr.dato == x) {
                eliminarInicio();
            } else if (ultimo.dato == x) {
                eliminarFin();
            } else {
                this.cantidad--;
                NodoDoble<E> p = ptr;
                do {
                    if (p.dato == x) {
                        break;
                    }
                    p = p.sig;
                } while (p != null);
                if (p != null) {
                    p.ant.sig = p.sig;
                    p.sig.ant = p.ant;
                    p = null;
                }
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.ptr == null && this.ultimo == null;
    }

    @Override
    public String mostrar() {
        String list = "";
        NodoDoble<E> p = ptr;
        do {
            list += p.dato + " ";
            p = p.sig;
        } while (p != null);

        return list;
    }

    @Override
    public void insertarDespues(E x, E y) {
        if (!isEmpty()) {
            NodoDoble<E> nuevo = new NodoDoble<>(y);
            if (ultimo.dato == x) {
                insertarFin(y);
            } else {
                cantidad++;

                NodoDoble<E> p = ptr;
                do {
                    if (p.dato == x) {
                        break;
                    }
                    p = p.sig;
                } while (p != null);
                //System.out.println(p.dato);
                nuevo.ant = p;
                nuevo.sig = p.sig;
                p.sig.ant = nuevo;
                p.sig = nuevo;

            }

        } else {
            insertarInicio(y);
        }
    }

    @Override
    public void insertarAntes(E x, E y) {
        if (!isEmpty()) {
            cantidad++;
            NodoDoble<E> nuevo = new NodoDoble<>(y);
            if (ptr.dato == x) {
                insertarInicio(y);
            } else {
                NodoDoble<E> p = ptr;
                do {
                    p = p.sig;
                } while (p.dato != x);
                //System.out.println(p.dato);
                nuevo.sig = p;
                nuevo.ant = p.ant;
                p.ant.sig = nuevo;
                p.ant = nuevo;
            }

        } else {
            insertarInicio(y);
        }
    }

    @Override
    public int cantidad() {
        return cantidad;
    }

}
