/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arep.reflexion;

/**
 *
 * @author 2098325
 */
public class Calculadora {
        
    @Web("/cal") public static int cuadrado(int val){
    
        return val*val;
    }
}
