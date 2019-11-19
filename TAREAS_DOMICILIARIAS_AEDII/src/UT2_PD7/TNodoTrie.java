package UT2_PD7;

import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 10;
    private TNodoTrie[] hijos;
    private TAbonado abonado;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
    }

    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrie nodo = this;
        for (int c = 0; c < primerosDigitos.length(); c++) {
            int indice = primerosDigitos.charAt(c) - '0';
            if (nodo.hijos[indice] != null) {
                nodo = nodo.hijos[indice];
            }
        }
        buscarTelefonos(abonados, nodo);
    }

    private void buscarTelefonos(LinkedList<TAbonado> abonados, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.abonado != null) {
                abonados.add(nodo.abonado);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    buscarTelefonos(abonados, nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        String numero = unAbonado.getTelefono();
        TNodoTrie nodo = this;
        for (int c = 0; c < numero.length(); c++) {
            int indice = numero.charAt(c) - '0';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.abonado = unAbonado;
    }

}
