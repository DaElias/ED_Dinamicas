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
public interface ListaDoble<E> {
    void insertarFin(E x);
    void eliminarFin();
    void eliminarInicio();
    void eliminar(E x);
    int cantidad();
    String mostrar();
    E obtener(int pos);
    boolean vacia();
    
    void insertarDespues(E x,E y);
    void insertarAntes(E x,E y);
}
