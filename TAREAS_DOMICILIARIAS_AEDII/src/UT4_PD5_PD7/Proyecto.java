package UT4_PD5_PD7;

import java.util.LinkedList;

public class Proyecto {

    public static void main(String[] args) {

        LinkedList<TVertice> verticesList = new LinkedList<>();
        TAristas aristasList = new TAristas();
        // cargar los archivos de tareas y precedencias
        // generar una lista con los vertices y una lista de aristas
        String[] pred = ManejadorArchivosGenerico.leerArchivo("src/UT4_PD5_PD7/precedencias.txt", true);
        for (String p : pred) {
            String[] data = p.split(",");
            aristasList.add(new TArista(data[0], data[1], Double.parseDouble(data[2])));
        }
        pred = ManejadorArchivosGenerico.leerArchivo("src/UT4_PD5_PD7/tareas.txt", true);
        for (String p : pred) {
            String[] data = p.split(",");
            verticesList.add(new TVertice(data[0],new Tarea(data[0],Integer.parseInt(data[1]))));
        }
        // instanciar el grafo dirigido, CON LAS ARISTAS EN EL SENTIDO APROPIADO!!!!

        TGrafoDirigido proyecto = new TGrafoDirigido(verticesList, aristasList.aristasInvertidas());
        

//      ejecutar el metodo para hallar el orden parcial para todo el proyecto
        
        LinkedList<Tarea> op = proyecto.ordenParcial();
        proyecto.listarTareas(op);
        System.out.println("Es conexo: " + proyecto.esConexoFuerte());
        // guardar las tareas en un archivo de texto "orden.txt" (para el primer conjunto de 
        // precedencias, y "orden2.txt" para el segundo.
    }
}
