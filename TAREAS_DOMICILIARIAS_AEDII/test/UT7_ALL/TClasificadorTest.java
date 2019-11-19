/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT7_ALL;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author tesit
 */
public class TClasificadorTest {

    private Comparable[] vectorPrueba;
    private final int tamanio = 300;
    private IClasificador tc;

    public TClasificadorTest() {
    }

    @Before
    public void init() {
        IGeneradorDatos gen = new GeneradorDatosGenericos();
        vectorPrueba = gen.generarDatosAleatorios();
        tc = new TClasificador();
    }

    @Test
    public void testInserDirec() {
        Comparable[] V = tc.clasificar(vectorPrueba.clone(),
                UT6_PD1.IClasificador.METODO_CLASIFICACION_INSERCION, false);
        for (int i = 0; i < V.length - 1; i++) {
            if (V[i].compareTo(V[i + 1]) > 0) {
                fail();
            }
        }
    }

    @Test
    public void testShell() {
        Comparable[] V = tc.clasificar(vectorPrueba.clone(),
                UT6_PD1.IClasificador.METODO_CLASIFICACION_SHELL, false);
        for (int i = 0; i < V.length - 1; i++) {
            if (V[i].compareTo(V[i + 1]) > 0) {
                fail();
            }
        }
    }

    @Test
    public void testBurbuja() {
        Comparable[] V = tc.clasificar(vectorPrueba.clone(),
                UT6_PD1.IClasificador.METODO_CLASIFICACION_INSERCION, false);
        for (int i = 0; i < V.length - 1; i++) {
            if (V[i].compareTo(V[i + 1]) > 0) {
                fail();
            }
        }
    }

    @Test
    public void testSeleccion() {
        Comparable[] V = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_SELECCION, false);
        for (int i = 0; i < V.length - 1; i++) {
            if (V[i].compareTo(V[i + 1]) > 0) {
                fail();
            }
        }
    }

    @Test
    public void testHeapSort() {
        Comparable[] V = tc.clasificar(vectorPrueba.clone(),
                IClasificador.METODO_CLASIFICACION_HEAPSORT, false);
        for (int i = 0; i < V.length - 1; i++) {
            if (V[i].compareTo(V[i + 1]) > 0) {
                fail();
            }
        }
    }

    @Test
    public void testQuiksort() {
        Comparable[] V = tc.clasificar(vectorPrueba.clone(),
                UT6_PD1.IClasificador.METODO_CLASIFICACION_QUICKSORT, false);
        for (int i = 0; i < V.length - 1; i++) {
            if (V[i].compareTo(V[i + 1]) > 0) {
                fail();
            }
        }
    }

}
