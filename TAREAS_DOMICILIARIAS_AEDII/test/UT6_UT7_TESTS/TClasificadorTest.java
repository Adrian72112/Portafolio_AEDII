/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT6_UT7_TESTS;

import UT6_PD1.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Adrián Tesore
 */
public class TClasificadorTest {

    private int[] vectorPrueba;
    private final int tamanio = 300;
    private IClasificador tc;

    public TClasificadorTest() {
    }

    @Before
    public void init() {
        IGeneradorDatos gen = new GeneradorDatosGenericos();
        vectorPrueba = gen.generarDatosAscendentes();
        tc = new TClasificador();
    }

    @Test
    public void testInserDirec() {
        int[] V = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_INSERCION, false);
        for (int i = 0; i < V.length - 1; i++) {
            if (V[i] > V[i + 1]) {
                fail();
            }
        }
    }
    
     @Test
    public void testInserShacker() {
        int[] V = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_SHAKER, false);
        for (int i = 0; i < V.length - 1; i++) {
            if (V[i] > V[i + 1]) {
                fail();
            }
        }
    }
    
     @Test
    public void testBinsortTrivial() {
        int[] V = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_BINSORT_TRIVIAL, false);
        for (int i = 0; i < V.length - 1; i++) {
            System.out.println(V[i]);
            if (V[i] > V[i + 1]) {
                fail();
            }
        }
    }

    @Test
    public void testShell() {
        int[] V = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_SHELL,false);
        for (int i = 0; i < V.length - 1; i++) {
            if (V[i] > V[i + 1]) {
                fail();
            }
        }
    }

    @Test
    public void testBurbuja() {
        int[] V = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_BURBUJA,false);
        for (int i = 0; i < V.length - 1; i++) {
            if (V[i] > V[i + 1]) {
                fail("Algoritmo Burbuja no correcto");
            }
        }
    }

    @Test
    public void testSeleccion() {
        int[] V = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_SELECCION, false);
        for (int i = 0; i < V.length - 1; i++) {
            if (V[i] > V[i + 1]) {
                fail("Algoritmo Burbuja no correcto");
            }
        }
    }
    
    @Test
    public void testRadixSort() {
        int[] V = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_RADIX, false);
        for (int i = 0; i < V.length - 1; i++) {
            if (V[i] > V[i + 1]) {
                fail("Algoritmo radix sort no correcto");
            }
        }
    }
    
    @Test
    public void testBinSort() {
        int[] V = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_BINSORT, false);
        for (int i = 0; i < V.length - 1; i++) {
            if (V[i] > V[i + 1]) {
                fail("Algoritmo binSort sort no correcto");
            }
        }
    }
    
    @Test
    public void testHeapSort() {
        int[] V = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_HEAPSORT, false);
        for (int i = 0; i < V.length - 1; i++) {
            if (V[i] > V[i + 1]) {
                fail("Algoritmo binSort sort no correcto");
            }
        }
    }
    
    @Test
    public void testOrdenarPorCuenta() {
        int[] V = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_CUENTA, false);
        for (int i = 0; i < V.length - 1; i++) {
            if (V[i] > V[i + 1]) {
                fail("Algoritmo POR CUENTA no correcto");
            }
        }
    }

    @Test
    public void testQuiksort() {
        int[] V = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_QUICKSORT, false);
        for (int i = 0; i < V.length - 1; i++) {
            if (V[i] > V[i + 1]) {
                fail("Algoritmo quicksort no correcto");
            }
        }
    }

}
