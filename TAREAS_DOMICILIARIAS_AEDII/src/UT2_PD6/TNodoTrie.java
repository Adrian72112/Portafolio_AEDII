package UT2_PD6;

import java.util.ArrayList;
import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;

    //posicion saber
    private int posicion;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        posicion = -1;

    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    public void insertar(String unaPalabra, int posicion) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        nodo.posicion = posicion;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {

        imprimir("", this);
    }

    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }

    private boolean buscarPatron(String s, String prefijo, TNodoTrie nodo, ArrayList<Integer> patrones) {
        if (nodo != null) {
            if (s.contains(prefijo) && !patrones.contains(s.indexOf(prefijo))) {
                if (!patrones.isEmpty())
                    patrones.add(s.indexOf(prefijo));
                else
                     patrones.add(s.indexOf(prefijo));
                s = "";
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    buscarPatron(s + (char) (c + 'a'), prefijo, nodo.hijos[c],patrones);
                }
            }
        }
        return !patrones.isEmpty();
    }

    public boolean buscarPatron(String prefijo,ArrayList<Integer> patrones) {
        TNodoTrie variable = this;
        if (variable != null) {
            return this.buscarPatron("", prefijo, variable,patrones);
        }
        return false;
    }

    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    predecir(s + (char) (c + 'a'), prefijo, palabras, nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie variable = buscarNodoTrie(prefijo);
        if (variable != null) {
            this.predecir("", prefijo, palabras, variable);
        }
    }

    @Override
    public int buscar(String palabra) {
        palabra = palabra.toLowerCase();
        int resultado = 0;
        TNodoTrie esteNodo = this;
        for (char caracter : palabra.toCharArray()) {
            int indice = caracter - 'a';
            if (esteNodo.hijos[indice] != null) {
                esteNodo = esteNodo.hijos[indice];
                resultado++;
            } else {
                return 0;
            }
        }
        return resultado;
    }

}
