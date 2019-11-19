package UT2_PD7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;
     
    @Override
    public Collection<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList<TAbonado> buscarTelefonos = new LinkedList<>();
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.buscarTelefonos(pais + area , buscarTelefonos);
        return buscarTelefonos;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(unAbonado);
    }

    
}
