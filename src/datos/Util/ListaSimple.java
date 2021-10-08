/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.Util;

/**
 *
 * @author davidcerchiaro
 */
public interface ListaSimple<E> {

    void insertarFin(E x);

    void insertarInicio(E x);

    void eliminarFin();
    
    void eliminarPos(int pos);

    void eliminarInicio();
    boolean buscar(E x);
    int cantidad();

    String mostrar();

    E obtener(int pos);

    boolean vacia();
}
