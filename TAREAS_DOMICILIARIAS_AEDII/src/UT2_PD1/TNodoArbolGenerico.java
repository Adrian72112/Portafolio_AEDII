/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2_PD1;

/**
 *
 * @author Adrian Tesore
 * @param <T>
 */
public class TNodoArbolGenerico<T> {
    
    public Comparable etiqueta;
    public TNodoArbolGenerico hermanoDerecho;
    public TNodoArbolGenerico primerHijo;
    public T datos;
    
    public TNodoArbolGenerico(Comparable etiqueta){
        this.etiqueta = etiqueta;
        this.hermanoDerecho = null;
        this.primerHijo = null;
    }
    
    public TNodoArbolGenerico(){
     
    }

    public void setHermanoDerecho(TNodoArbolGenerico hermanoDerecho) {
        this.hermanoDerecho = hermanoDerecho;
    }

    public void setPrimerHijo(TNodoArbolGenerico primerHijo) {
        this.primerHijo = primerHijo;
    }

    public void setDatos(T datos) {
        this.datos = datos;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public TNodoArbolGenerico getHermanoDerecho() {
        return hermanoDerecho;
    }

    public TNodoArbolGenerico getPrimerHijo() {
        return primerHijo;
    }

    public T getDatos() {
        return datos;
    }

    public void preOrden(){
        System.out.println(etiqueta);
        TNodoArbolGenerico unHijo = primerHijo;
        while (unHijo != null){
            unHijo.preOrden();
            unHijo = unHijo.hermanoDerecho;
        }
    }
    
    public TNodoArbolGenerico buscar(Comparable unaEtiqueta){
        if (etiqueta.compareTo(unaEtiqueta) == 0){
            return new TNodoArbolGenerico(unaEtiqueta);
        }
        TNodoArbolGenerico unHijo = primerHijo;
        TNodoArbolGenerico aux = null;
        while (unHijo != null){
            aux = unHijo.buscar(unaEtiqueta);
            if (aux != null){
                return aux;
            }
            unHijo = unHijo.hermanoDerecho;
        }
        return aux;
    }

    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre){
        TNodoArbolGenerico auxNodo = primerHijo;     
        if (etiqueta.compareTo(etiquetaPadre) == 0){
            this.setPrimerHijo(new TNodoArbolGenerico(unaEtiqueta));
            primerHijo.setHermanoDerecho(auxNodo);
            return true;
        }
        while (auxNodo != null){
            auxNodo.insertar(unaEtiqueta, etiquetaPadre);
            auxNodo = auxNodo.getHermanoDerecho();
        }
        return false;
    }    
    
    public String listarIndentado(String separator){
        String listaIndentada = etiqueta + "\n";
        TNodoArbolGenerico unHijo = primerHijo;
        separator += "\t";
        while (unHijo != null){
            listaIndentada += separator + unHijo.listarIndentado(separator);
            unHijo = unHijo.hermanoDerecho;
        }
        return listaIndentada;
    }   
    
    //    public String listarIndentado(String separator){
//        System.out.println(separator + etiqueta);
//        //String listaIndentada = etiqueta + "\n";
//        TNodoArbolGenerico unHijo = primerHijo;
//        separator += "\t";
//        while (unHijo != null){
//            //listaIndentada += separator + unHijo.listarIndentado(separator);
//            unHijo.listarIndentado(separator);
//            unHijo = unHijo.hermanoDerecho;
//        }
//        return "";
//    } 
}

