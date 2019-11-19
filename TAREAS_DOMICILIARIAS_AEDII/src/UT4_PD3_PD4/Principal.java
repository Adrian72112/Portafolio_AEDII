/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4_PD3_PD4;


/**
 *
 * @author tesit
 */
public class Principal {
    
    public static void main(String... args){
        TGrafoDirigido grd = UtilGrafos.cargarGrafo("src/UT4_PD3_PD4/aeropuertos.txt", "src/UT4_PD3_PD4/conexiones.txt", 
                false, TGrafoDirigido.class);
        
        UtilGrafos.imprimirMatrizMejorado(grd.floyd(), grd.getVertices(), "Matriz");
        
        System.out.println("Centro:" + grd.centroDelGrafo());
        
        System.out.println("¿Existen conexión(es) entre Montevideo y Curitiba? :" + 
                grd.existeConexion("Montevideo", "Curitiba"));
        
        System.out.println("¿Existen conexión(es) entre Porto Alegre y Santos? : " +
                grd.existeConexion("Porto_Alegre", "Santos"));
        
         System.out.println("\n \n");;
        System.out.println("BPF DESDE MONTEVIDEO:");
        grd.bpf("Montevideo").forEach((t) -> {
            System.out.print(t.getEtiqueta() + " -> ");
        });
        
        System.out.println("\n \n");
        System.out.println("Todos los caminos Montevideo a Rio:");
        TCaminos caminos = grd.todosLosCaminos("Montevideo", "Rio_de_Janeiro");
        caminos.imprimirCaminosConsola();
    }
    
}
