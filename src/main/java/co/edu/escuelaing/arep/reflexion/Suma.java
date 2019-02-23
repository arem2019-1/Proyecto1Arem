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
public class Suma {
            /**
     * Calcula la suma de un numero 
     * <p>Calcula la suma de un numero consigo mismo</p>
     * @param al
     * @return Integer
     */
    @Web("/al")
    public static int su(int al) {
        int r=al+al;
        return r;
    }
}
