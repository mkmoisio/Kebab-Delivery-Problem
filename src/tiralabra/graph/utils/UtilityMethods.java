/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph.utils;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mikkomo
 */
public class UtilityMethods {

    /**
     * Palautetavan 2D taulukon koko. Voidaan poistaa kun saadaan verkko, jossa mikään solmunumero ei jää välistä.
     */
    public static final int MAGIC_SEVENTY = 70;

    /**
     *
     * @param list listaesitys verkosta
     * @return verkon vierusmatriisiesitys
     */
    public static int[][] fromStringListToint2DArray(List<String> list) {
        int[][] array2D = new int[MAGIC_SEVENTY][MAGIC_SEVENTY];
       
        for (int[] array1D : array2D) {
            Arrays.fill(array1D, -1);
        }
        
        list.forEach(item -> {
            int[] tmp = new int[MAGIC_SEVENTY];
            Arrays.fill(tmp, -1);
            String[] tmpString = item.split(":");
            int nodeNumber = Integer.parseInt(tmpString[0]);    
            
            for (int i = 1; i < tmpString.length; i += 2) {
                
                tmp[Integer.parseInt(tmpString[i])] = Integer.parseInt(tmpString[i + 1]);
            }

            array2D[nodeNumber] = tmp;

        });
        
        for (int i = 0; i < MAGIC_SEVENTY; i++) {
            array2D[i][i] = 0;
        }
        return array2D;
    }
    
    /**
     * 2D-taulukon tulostus debuggaustarkoituksiin
     * @param array2D
     */
    public static void print2DArray(int[][] array2D) {
        for (int i = 0; i < array2D[0].length; i++) {
            System.out.println(Arrays.toString(array2D[i]));
        }
    }

  
}
