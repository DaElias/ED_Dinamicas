/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import datos.estructuras.ListaSimpleNodo;
import datos.Util.ListaSimple;
import datos.estructuras.ListaCircular;

/**
 *
 * @author davidcerchiaro
 */
public class Test {

    public static void main(String[] args) {
        ListaSimple<Integer> lista = new ListaCircular<>();
//      lista.insertarInicio(1);
//        lista.insertarInicio(2);
//        lista.insertarInicio(3);
//        lista.insertarInicio(4);
        lista.insertarFin(1);
        lista.insertarFin(2);
        lista.insertarFin(3);
        lista.insertarFin(4);
        lista.insertarFin(5);
        lista.insertarFin(6);
        lista.insertarFin(7);
        //lista.eliminarInicio();
        System.out.println(lista.mostrar());
        lista.eliminarFin();
        System.out.println("Cantidad: "+lista.cantidad());
        System.out.println(lista.mostrar());

//        System.out.println(lista.mostrar());
        // System.out.println(lista.cantidad());
//
//        lista.insertarFin(new Alumno("Juan", 10, 2));
//        lista.insertarFin(new Alumno("Danilo", 60, 22));
//        lista.insertarFin(new Alumno("Majo", 19, 21));
//        lista.insertarFin(new Alumno("Mario Bros", 112, 21));
        //busqueda por edad
        //System.out.println(lista.buscar(new Alumno("", 0, 2)));
    

//        System.out.println(lista.obtener(0));
    }
}
