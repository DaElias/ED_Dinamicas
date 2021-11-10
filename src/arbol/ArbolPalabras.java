/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

import java.util.ArrayList;
import uac.util.Arbin;
import uac.util.ArbolEnl;

/**
 *
 * @author davidcerchiaro
 */
public class ArbolPalabras {

    private String mayor = "",hijos="";
    private ArrayList<String> hoja = new ArrayList<>();
    
    public String darHijos(Arbin<String> r, String padre) {
        if (r != null) {
            buscarHijos(r,padre);
            darHijos(r.izq(), padre);
            darHijos(r.der(), padre);
        }
        return this.hijos;
        
    }

    private void buscarHijos(Arbin<String> r,String padre) {
        if (r.obtener().equals(padre)) {
            if (r.izq() != null) {
                this.hijos+="  "+r.izq().obtener();
            }
            if (r.der()!= null) {
                this.hijos+="  "+r.der().obtener();
            }
        }
    }

    public ArrayList<String> hojas(Arbin<String> r) {
        if (r != null) {
            visitaH(r);
            hojas(r.izq());
            hojas(r.der());
        }
        return this.hoja;
    }

    private void visitaH(Arbin<String> r) {
        if (r.izq() == null && r.der() == null) {
            this.hoja.add(r.obtener());
        }
    }

    public String mayor(Arbin r) {
        if (r != null) {
            visita(r);
            mayor(r.izq());
            mayor(r.der());
        }
        return this.mayor;
    }

    private void visita(Arbin<String> r) {
        if (r.obtener().compareTo(this.mayor) > 0) {
            this.mayor = r.obtener();
        }
    }

    public Arbin<String> crearArbol() {
        Arbin<String> raiz = new ArbolEnl<>("Alberta");
        Arbin<String> i = new ArbolEnl<>("Zapata");
        Arbin<String> d = new ArbolEnl<>("Jua");
        raiz.enlIzq(i);
        raiz.enlDer(d);
        Arbin<String> ii = new ArbolEnl<>("Diomedes");
        Arbin<String> dd = new ArbolEnl<>("JuanCamiloza");
        i.enlIzq(ii);
        d.enlDer(dd);
        return raiz;
    }

    public int peso(Arbin<String> r) { //recursivo 
        if (r == null) {
            return 0;
        } else {
            return 1 + peso(r.izq()) + peso(r.der());
        }
    }

    //R-i-d (raíz, izquierda, derecha)
    public void preOrden(Arbin<String> r) {
        if (r != null) {
            System.out.println(" " + r.obtener()); //R
            preOrden(r.izq()); //i
            preOrden(r.der()); //d
        }
    }

    //i-R-d (izquierda, raíz, derecha)
    public void inOrden(Arbin<String> r) {
        if (r != null) {
            inOrden(r.izq()); //i
            System.out.println(" " + r.obtener()); //R
            inOrden(r.der()); //d
        }
    }

    //i-d-R  (izquierda, derecha, raíz)
    public void posOrden(Arbin<String> r) {
        if (r != null) {
            posOrden(r.izq()); //i
            posOrden(r.der()); //d
            System.out.println(" " + r.obtener()); //R

        }
    }

    public boolean buscar(Arbin r, String x) {
        if (r == null) {
            return false;
        } else {
            return (r.obtener().equals(x) || buscar(r.izq(), x) || buscar(r.der(), x));
        }
    }

    public int altura(Arbin r) {
        if (r == null) {
            return 0;
        } else {
            return 1 + Math.max(altura(r.izq()), altura(r.der()));
        }
    }

    public static void main(String[] args) {
        ArbolPalabras ar = new ArbolPalabras();
        Arbin<String> raiz = ar.crearArbol();
        System.out.println("PosOrden\n");
        ar.posOrden(raiz);
        System.out.println("inOrden\n");
        ar.inOrden(raiz);
        System.out.println("preOrden\n");
        ar.preOrden(raiz);
        System.out.println("Peso : " + ar.peso(raiz) + "\n");
        System.out.println("Altura: " + ar.altura(raiz));
        System.out.println("Buscar: ''Derecha''-> " + ar.buscar(raiz, "Derecha"));
        System.out.println("Mayor: " + ar.mayor(raiz));
        System.out.println("Mostrar hojas: " + ar.hojas(raiz));
        System.out.println("Dar hijos: 'Alberta' "+ar.darHijos(raiz, "Alberta"));
    }

}
