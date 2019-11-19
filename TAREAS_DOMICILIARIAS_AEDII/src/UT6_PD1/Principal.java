/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT6_PD1;

import static UT6_PD1.IClasificador.*;

/**
 *
 * @author tesit
 */
public class Principal {

    public static void main(String args[]) {
        IClasificador clasif = new TClasificador();
        IGeneradorDatos gdg = new GeneradorDatosGenericos();
        int[] vectorAleatorio = gdg.generarDatosAleatorios();
        int[] vectorAscendente = gdg.generarDatosAscendentes();
        int[] vectorDescendente = gdg.generarDatosDescendentes();
        int[] vectorAlgo = {97,19,61,07,34,25,82,56};
        int[] resAleatorio = clasif.clasificar(vectorAlgo,
                METODO_CLASIFICACION_QUICKSORT, false);
        for (int i = 0; i < resAleatorio.length; i++) {
            System.out.println(resAleatorio[i] + " ");
        }

    }
}
