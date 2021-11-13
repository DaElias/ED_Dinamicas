/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author David_Cerchiaro
 */
public class ArbolPalabras {
    
    public Arbin<String> crearArbol(){
        Arbin<String> raiz=new ArbolEnl<>("Alberta");
        Arbin<String> i=new ArbolEnl<>("Zapata");
        Arbin<String> d=new ArbolEnl<>("Miranda");
        raiz.enlIzq(i);
        raiz.enlDer(d);
        Arbin<String> ii=new ArbolEnl<>("Henriquez");
        Arbin<String> dd=new ArbolEnl<>("Alvarez");
        i.enlIzq(ii);
        d.enlDer(dd);
        
        return raiz;
        
    }
    Arbin<String> raiz=null;
    
    
    public int peso(Arbin<String> r){
        if(r==null)
            return 0;
        else
            return 1+peso(r.izq())+peso(r.der());
    }
    public int altura(Arbin<String> r){
        if(r==null)
            return 0;
        else
            return 1+Math.max(altura(r.izq()), altura(r.der()));
    }
    //R-I-D
    public void preorden(Arbin<String> r){
        if(r!=null){
            System.out.println(" "+r.obtener());//R
            
            preorden(r.izq()); //I
            preorden(r.der()); //D
        }
    }
    public void inorden(Arbin<String> r){
        if(r!=null){
            inorden(r.izq()); //I
            System.out.println(" "+r.obtener());//R
            inorden(r.der()); //D
        }
    }
    ArrayList<String> hojas=new ArrayList<>();
    public ArrayList<String> hojas(Arbin<String> r){
        if(r!=null){
            visitaH(r);
            hojas(r.izq());
            hojas(r.der());
        }
        return hojas;
    }
    
    String mayor="";
    public String mayor(Arbin<String> r){
        if(r!=null){
            visita(r);
            mayor(r.izq());
            mayor(r.der());
        }
        return mayor;
    }
    
    //I_D-R
    public void posorden(Arbin<String> r){
        if(r!=null){
            
            posorden(r.izq()); //I
            posorden(r.der()); //D
            System.out.println(" "+r.obtener());//R
        }
    }
    //I-R-D
    public boolean buscar(Arbin<String> r, String x){
        if(r==null)
            return false;
        else{
            return (r.obtener().equals(x) || buscar(r.izq(), x) || buscar(r.der(),x));
        }
    }
    public String mayorABB(){
        if(raiz!=null)
          return mayorABB(raiz);
        else
            return null;
    }
    private String mayorABB(Arbin<String> r) {
        if(r.der()==null)
            return r.obtener();
        else
            return mayorABB(r.der());
    }
    public Arbin<String> may(Arbin<String> r){
        while(r.der()!=null)
            r=r.der();
        
        return r;
    }
    
    public void mostrar(){
        inorden(raiz);
    }
    String hijos="";
    public String darHijos(Arbin<String> r, String padre){
        if(r!=null){
            buscarHijos(r,padre);
            darHijos(r.izq(), padre);
            darHijos(r.der(), padre);
        }
        return hijos;
    }
    private void visita(Arbin<String> r) {
        if(r.obtener().compareTo(mayor)>0){
            mayor=r.obtener();
        }
    }

    private void visitaH(Arbin<String> r) {
        if(r.izq()==null && r.der()==null){
            hojas.add(r.obtener());
        }
    }

    private void buscarHijos(Arbin<String> r, String padre) {
       if(r.obtener().equals(padre)){
           if(r.izq()!=null){
               hijos+=" "+r.izq().obtener();
           }
           if(r.der()!=null){
               hijos+=" "+r.der().obtener();
           }
       } 
    }
    public void insertar(String pal){
           if(raiz==null)
            raiz=new ArbolEnl<>(pal);
        else
            insertar(raiz,pal);
    }
    private void insertar(Arbin<String> r, String pal) {
        if(pal.compareTo(r.obtener())<0){
            if(r.izq()==null)
                r.enlIzq(new ArbolEnl<>(pal));
            else
                insertar(r.izq(), pal);
        }else{
            if(r.der()==null)
                r.enlDer(new ArbolEnl<>(pal));
            else
                insertar(r.der(), pal);
            }
    }

    public boolean buscarABB(String pal){
        if(raiz==null)
            return false;
        else
            return buscarABB(raiz,pal);
    }
    private boolean buscarABB(Arbin<String> r, String pal) {
        if(r.obtener().equals(pal))
            return true;
        else{
            if(pal.compareTo(r.obtener())<0){
                if(r.izq()==null)
                    return false;
                else
                    return buscarABB(r.izq(), pal);
            }else{
                if(r.der()==null)
                    return false;
                else
                    return buscarABB(r.der(), pal);
                
            }
        }
    }

    public void eliminar(String pal){
        if(buscarABB(pal)){
            raiz=eliminar(raiz,pal);
        }
    }
    private Arbin<String> eliminar(Arbin<String> r, String pal) {
        if(r.obtener().equals(pal)){
            return borrar(r);
        }else{
            if(pal.compareTo(r.obtener())<0){
                r.enlIzq(eliminar(r.izq(), pal));
            }else{
                r.enlDer(eliminar(r.der(), pal));
            }
            return r;
            
        }
    }

    private Arbin<String> borrar(Arbin<String> r) {
        if(r.izq()==null && r.der()==null)
            return null;
        else if(r.izq()==null)
            return r.der();
        else if(r.der()==null)
            return r.izq();
        else{
            String may= mayorABB(r.izq());
            r.cambiar(may);
            r.enlIzq(eliminar(r.izq(), may));
            return r;
         }
    }

    
        public static void main(String[] args) {
        ArbolPalabras ar=new ArbolPalabras();
        ar.insertar("pronto ");
        ar.insertar("juega ");
        ar.insertar("colombia ");
        ar.insertar("alegria ");
        ar.insertar("futbol ");
        ar.mostrar();
        System.out.println(" Buscar "+ar.buscarABB("colombia "));
        System.out.println(" Mayor "+ar.mayorABB());
        ar.eliminar("pronto ");
        System.out.println(" Despues de borrado ");
        ar.mostrar();
        
        
//        Arbin<String> raiz = ar.crearArbol();
//        System.out.println(" Peso "+ar.peso(raiz));
//        System.out.println("Preorden");
//        ar.preorden(raiz);
//        System.out.println("Posorden");
//        ar.posorden(raiz);
//        System.out.println("Altura "+ar.altura(raiz));
//        System.out.println(" Buscar "+ar.buscar(raiz, "Der"));
//        System.out.println(" Pal Mayor "+ar.mayor(raiz));
//        System.out.println(" Hojas "+ar.hojas(raiz).toString());
//        System.out.println(" Hijos "+ar.darHijos(raiz, "Alvarez"));
    }
    
}