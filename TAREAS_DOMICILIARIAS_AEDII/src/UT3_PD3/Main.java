/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3_PD3;

import UT3_PD4.ManejadorArchivosGenerico;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tesit
 */
public class Main {

    public static void main(String... args) {
        printSortedByLenght(ManejadorArchivosGenerico.leerArchivo("src/UT3_PD3/palabrasEx.txt"));
    }

    // UT3 PD3, EJERCICIO 1
    static void deleteAllNull(Map hf) {
        hf.forEach((t, u) -> {
            if (u == null) {
                hf.remove(t);
            }
        });
    }

    // UT3 PD3, EJERCICIO 2 INTERCAMBIAR LUGARES DE UN MAP
    static Map<String, String> intercambiarValores(Map<String, String> h) {
        Map<String, String> val = new HashMap<>();
        h.forEach((t, u) -> {
            if (val.get(u) != null) {
                System.out.println("Valor duplicado weon!");
            } else {
                val.put(u, t);
            }
        });
        return val;
    }

    // UT3 PD3 , EJERCICIO 3 IMPRIMIR ORDENADO POR LONGITUD Y SI SON = ALFABETICAMENTE
    static void printSortedByLenght(String[] entrada) {
        List<String> cities = new ArrayList<>();
        cities.addAll(Arrays.asList(entrada));
        cities.sort((first, second) -> {
            if (Integer.compare(second.length(), first.length()) == 0)
                return first.compareTo(second);
            return Integer.compare(second.length(), first.length());
        });
        cities.forEach((t) -> {
            System.out.println(t);
        });
    }
}
