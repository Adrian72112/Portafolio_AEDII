/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4_PD2;

/**
 *
 * @author tesit
 */
public class Principal {
    
    public static void main(String... args){
        TGrafoDirigido grd = UtilGrafos.cargarGrafo("src/UT4_PD2/ciudades.txt", "src/UT4_PD2/conexiones.txt", false, TGrafoDirigido.class);
        Double[][] costo = UtilGrafos.obtenerMatrizCostos(grd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(costo, grd.getVertices(),"MATRIZ");
        
        Double[][] mfloyd = grd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, grd.getVertices(), "Matriz luego de FLOYD");
        
        System.out.println("Excentricidad de Durazno: " + grd.obtenerExcentricidad("Durazno"));
        
        System.out.println("Centro del grafo: " + grd.centroDelGrafo());
    }
    
}
