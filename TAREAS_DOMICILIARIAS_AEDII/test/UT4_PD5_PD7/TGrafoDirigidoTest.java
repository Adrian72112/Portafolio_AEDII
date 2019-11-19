/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4_PD5_PD7;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runners.Parameterized;

/**
 *
 * @author tesit
 */
public class TGrafoDirigidoTest {

    private TGrafoDirigido grd;
    
    @Before
    public void TGrafoDirigidoTest() {
        grd = new TGrafoDirigido(getVertices(), getAristas());
    }

    @Parameterized.Parameters
    public static TAristas getAristas() {
        TAristas ari = new TAristas();
        ari.add(new TArista("a", "b", 1));
        ari.add(new TArista("b", "c", 1));
      
        ari.add(new TArista("a", "c", 1));
        return ari;
    }

    @Parameterized.Parameters
    public static Collection<TVertice> getVertices() {
        Collection<TVertice> vt = new LinkedList<TVertice>();
        vt.add(new TVertice("a"));
        vt.add(new TVertice("b"));
        vt.add(new TVertice("c"));
        vt.add(new TVertice("d"));
        return vt;
    }

    @Test
    public void testDesvisitarVertices() {
        System.out.println("desvisitarVertices");
        TGrafoDirigido instance = null;
        instance.desvisitarVertices();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetVertices() {
        System.out.println("getVertices");
        TGrafoDirigido instance = null;
        Map<Comparable, TVertice> expResult = null;
        Map<Comparable, TVertice> result = instance.getVertices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testListarTareas() {
        System.out.println("listarTareas");
        LinkedList listaTareas = null;
        TGrafoDirigido instance = null;
        instance.listarTareas(listaTareas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testOrdenParcial() {
        System.out.println("ordenParcial");
        TGrafoDirigido instance = null;
        LinkedList<Tarea> expResult = null;
        LinkedList<Tarea> result = instance.ordenParcial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testEsConexo() {
        System.out.println("esConexo");
        assertEquals(false, this.grd.esConexoFuerte());
    }

    @Test
    public void testTieneCiclo() {
        System.out.println("tieneCiclo");
        assertEquals(false, grd.tieneCiclo());
    }

}
