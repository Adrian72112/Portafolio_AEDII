/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3_PD4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tesit
 */
public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] palabras = ManejadorArchivosGenerico.leerArchivo("src/UT3_PD4/libro.txt");
        for (String pt : palabras) {
            String[] palabrasLinea = pt.split("\\W+");
            for (String p : palabrasLinea) {
                if (map.containsKey(p)) {
                    map.replace(p, map.get(p) + 1);
                } else {
                    map.put(p, 1);
                }
            }

        }
        HashMap<String, Integer> sortedMap = ordenarPorValor(map);
        ArrayList<String> writeFile;
        writeFile = new ArrayList();
        sortedMap.forEach((t, u) -> {
            writeFile.add(t + "," + u);
        });
        ManejadorArchivosGenerico.escribirArchivo("src/UT3_PD4/frecuencias.txt", writeFile);
    }
        // Ordenar HashMap by values
    public static HashMap<String, Integer> ordenarPorValor(HashMap<String, Integer> hm) {
        // Crear lista de elemenos HashMap
        List<Map.Entry<String, Integer>> list = new LinkedList<>(hm.entrySet());

        // Aqui hacemos la comparacion y ordenamos 
        Collections.sort(list, (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
                -> (o1.getValue()).compareTo(o2.getValue()));

        // Volvemos a volcar los datos al HashMap con la lista ya ordenada
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        list.forEach((aa) -> {
            temp.put(aa.getKey(), aa.getValue());
        });
        return temp;
    }

}
