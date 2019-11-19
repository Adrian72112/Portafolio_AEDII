/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2_PD1;

/**
 *
 * @author Adrian Tesore
 */
public class TArbolGenerico {
    
    public TNodoArbolGenerico raiz;
    
    public TArbolGenerico(TNodoArbolGenerico raiz){
        this.raiz = raiz;
    }
    
    public TArbolGenerico(){
        
    }

    public TNodoArbolGenerico getRaiz() {
        return raiz;
    }

    public void setRaiz(TNodoArbolGenerico raiz) {
        this.raiz = raiz;
    }
    
    public void preOrden(){
        if (raiz != null){
            raiz.preOrden();
        }
    }
    
    public boolean insertar(Comparable unaEtiqueta,Comparable etiquetaPadre){
        if (raiz != null){
            return raiz.insertar(unaEtiqueta, etiquetaPadre);
        } else if (etiquetaPadre.compareTo("") == 0) {
            setRaiz(new TNodoArbolGenerico(unaEtiqueta));
            return true;
        }
        return false;
    }
    
    public TNodoArbolGenerico buscar(Comparable unaEtiqueta){
        if (raiz != null){
            return raiz.buscar(unaEtiqueta);
        }
        return null;
    }
    
    public String listarIndentado(){
        if (raiz != null){
            return raiz.listarIndentado("");
        }
        return null;
    }
}
