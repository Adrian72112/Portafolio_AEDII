package UT2_PD6;

import java.util.ArrayList;
import java.util.LinkedList;

public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        return raiz.buscar(palabra);
    }
    
    public boolean buscarPatron(String palabra,ArrayList<Integer> patrones){
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        return raiz.buscarPatron(palabra,patrones);
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> predecir = new LinkedList<>();
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.predecir(prefijo,predecir);
        return predecir;
    }

}
