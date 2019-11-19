/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2_PD1;
// ARBOL GENERICO AQUI
/**
 *
 * @author Adrian Tesore
 */
public class Main {
    
    public static void main(String[] args){
         // TODO code application logic here

        TArbolGenerico arbol = new TArbolGenerico();
        arbol.insertar("Rectoría", "");
        arbol.insertar("Vicerectoría administrativa", "Rectoría");
        arbol.insertar("Vicerectoría académica", "Rectoría");
        arbol.insertar("Vicerectoría del medio universitario", "Rectoría");     
        arbol.insertar("Facultad de psicología","Vicerectoría académica");
        arbol.insertar("Facultad de ingeniería y tecnologías",
                "Vicerectoría académica");
        arbol.insertar("Facultad de ciencias humanas",
                "Vicerectoría académica");
        arbol.insertar("Facultad de ciencias empresariales",
                "Vicerectoría académica");
        arbol.insertar("Departamento de matemáticas",
                "Facultad de ingeniería y tecnologías");
        arbol.insertar("Departamento de ingeniería eléctrica",
                "Facultad de ingeniería y tecnologías");  
        arbol.insertar("Departamento de informática y "
                + "ciencias de la computación",
                "Facultad de ingeniería y tecnologías");           
        System.out.println(arbol.listarIndentado());
                
    }
    
}
