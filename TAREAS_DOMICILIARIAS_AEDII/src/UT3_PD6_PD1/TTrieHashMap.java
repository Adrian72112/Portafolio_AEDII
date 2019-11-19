package UT3_PD6_PD1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author tesit
 */
public class TTrieHashMap implements IArbolTrie, Serializable {

    private TNodoTrieHashMap raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }

        raiz.insertar(palabra, 0);
    }

    public void encontrarPatron(String patron) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }
        LinkedList<Integer> locations = new LinkedList<>();
        raiz.encontrarPatron(patron, locations);
    }

    public void insertar(String palabra, int posicion) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }

        raiz.insertar(palabra, posicion);
    }

    @Override
    public LinkedList predecir(String c) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }
        LinkedList<String> lista = new LinkedList<>();
        raiz.predecir(c, lista);
        return lista;
    }

    @Override
    public int buscar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }

        return raiz.buscar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

}
