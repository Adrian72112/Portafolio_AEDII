/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3_PD6_PD1;

/**
 *
 * @author tesit
 */
public class ComparateMemo {

    private static final int REPETICIONES = 100;

    public static void main(String... args) {

        TTrieHashMap trie = new TTrieHashMap();
        IArbolTrie trie2 = new TArbolTrie();

        String[] secuencia = ManejadorArchivosGenerico.leerArchivo(""
                + "src/UT3_PD6_PD1/proteina.txt");
        String[] palabrasBuscar = ManejadorArchivosGenerico.leerArchivo(""
                + "src/UT3_PD6_PD1/palabras.txt");
        //TODO: CARGAR PALABRAS CON EL LECTOR DE ARCHIVOS GENÉRICO
         for (String elTexto : secuencia) {
            // cargar el árbol de sufijos en la forma apropiada
            for (int i = 0; i < elTexto.length(); i++) {
                String sufijo = elTexto.substring(i, elTexto.length());
                trie.insertar(sufijo, i);
            }
        }

        int i = 0;
        Medible[] medibles = new Medible[1];
        medibles[i++] = new MedicionBuscarTrie(trie);

        Medicion mi;
        i = 0;
        Object[] params = {REPETICIONES, palabrasBuscar};
        String[] lineas = new String[2];
        lineas[i++] = "algoritmo,tiempo,memoria";
        for (Medible m : medibles) {
            mi = m.medir(params);
            mi.print();
            lineas[i++] = mi.getTexto() + "," + mi.getTiempoEjecucion().toString() + "," + mi.getMemoria().toString();
        }

        ManejadorArchivosGenerico.escribirArchivo("src/UT3_PD6_PD1/salida.csv", lineas);

    }

    public static String filtrarPalabra(String unaPalabra) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < unaPalabra.length(); i++) {
            char caracter = unaPalabra.charAt(i);
            if ((caracter >= 'A' && caracter <= 'Z')
                    || (caracter >= 'a' && caracter <= 'z')) {
                sb.append(caracter);
            }

        }
        return sb.toString().toLowerCase();
    }
}
