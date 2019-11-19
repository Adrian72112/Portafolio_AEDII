package UT3_PD6_PD1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author tesit
 */
public class TNodoTrieHashMap implements Serializable {

    HashMap<Character, TNodoTrieHashMap> hijos = new HashMap();
    private boolean esPalabra;
    private int posicion;

    public TNodoTrieHashMap() {
        esPalabra = false;
        posicion = -1;
    }

    public void insertar(String unaPalabra, int posicion) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            Character letra = unaPalabra.charAt(c);
            if (nodo.hijos.get(letra) == null) {
                nodo.hijos.put(letra, new TNodoTrieHashMap());
            }
            nodo = nodo.hijos.get(letra);
        }
        nodo.esPalabra = true;
        nodo.posicion = posicion;
    }

    private void imprimir(String s, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (Character key : nodo.hijos.keySet()) {
                imprimir(s + key, nodo.hijos.get(key));
            }
        }
    }

    private TNodoTrieHashMap buscarNodoTrie(String s) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < s.length(); c++) {
            Character character = s.charAt(c);
            if (nodo.hijos.get(character) == null) {
                return null;
            }
            nodo = nodo.hijos.get(character);
        }
        return nodo;
    }

    private void encontrarPatron(String s, String prefijo, LinkedList<Integer> precond, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                precond.add(nodo.posicion);
            }
            for (Character caracter : nodo.hijos.keySet()) {
                if (nodo.hijos.get(caracter) != null) {
                    this.encontrarPatron(s + caracter, prefijo, precond, nodo.hijos.get(caracter));
                }
            }
        }
    }

    public void encontrarPatron(String patron, LinkedList<Integer> locations) {
        this.encontrarPatron("", patron, locations, buscarNodoTrie(patron));
    }

    private void predecir2(String s, LinkedList<String> lista, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                lista.add(s);
            }
            for (Character key : nodo.hijos.keySet()) {
                predecir2(s + key, lista, nodo.hijos.get(key));
            }
        }
    }

    public void predecir(String palabra, LinkedList<String> lista) {
        TNodoTrieHashMap variable = buscarNodoTrie(palabra);
        if (variable != null) {
            predecir2(palabra, lista, variable);
        }

        Collections.sort(lista);
    }


    public void imprimir() {
        imprimir("", this);
    }

    public int buscar(String palabra) {
        palabra = palabra.toLowerCase();
        int resultado = 0;
        TNodoTrieHashMap esteNodo = this;
        for (char caracter : palabra.toCharArray()) {
            if (esteNodo.hijos.get(caracter) != null) {
                esteNodo = esteNodo.hijos.get(caracter);
                resultado++;
            } else {
                return 0;
            }
        }
        return resultado;
    }
}
