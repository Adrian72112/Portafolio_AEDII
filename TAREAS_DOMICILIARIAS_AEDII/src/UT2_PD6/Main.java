/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2_PD6;

import java.util.ArrayList;

/**
 *
 * @author tesit
 */
public class Main {

    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();
        String s = "ana";
        String p = "panamabananas";
        for (int i = 0; i < p.length();i++){
            trie.insertar(p.substring(i, p.length()));
        }
        //trie.insertar("panamabananas");
        ArrayList<Integer> patrones = new ArrayList<>();
        
        trie.buscarPatron(s, patrones);
        System.out.println("Palabra a buscar: " + s);
        System.out.println(patrones.toString());
        
   
    }

}
