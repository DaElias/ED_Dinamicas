/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.Util;

/**
 *
 * @author davidcerchiaro y Daniel Yepes
 */
public interface TadListaDoble<E> {

    void insertarInicio(E x);

    void insertarFin(E x);

    void eliminarInicio();

    void eliminarFin();

    String mostrar();

    int cantidad();

    void eliminarElemento(E x);

    void insertarDespues(E x, E y);

    void insertarAntes(E x, E y);

    boolean isEmpty();
}
