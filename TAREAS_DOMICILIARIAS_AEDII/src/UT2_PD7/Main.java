package UT2_PD7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

       // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        String[] abonados = ManejadorArchivosGenerico.leerArchivo("src/UT2_PD7/abonados.txt");
        for (String abonado: abonados){
            trie.insertar(new TAbonado(abonado.split(",")[1],abonado.split(",")[0]));
        }
        
        String codigoPais = "054" ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "90" ;// utilizar el indicado en el archivo "codigos.txt"
        Collection<TAbonado> ab =  trie.buscarTelefonos(codigoPais, codigoArea);
        // crear el archivo "salida.txt", con los abonados (1 por linea) 
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
        ArrayList<String> imprimir = new ArrayList<>();
      
        int i = 0;
        ab.forEach((t) -> {
            imprimir.add(t.getTelefono() + "," + t.getNombre());
        });
       
       ManejadorArchivosGenerico.escribirArchivo("src/UT2_PD7/salida.txt", imprimir );
        
    }
}