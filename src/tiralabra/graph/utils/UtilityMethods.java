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

    public static final int MAGIC_SEVENTY = 70;

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
        return array2D;
    }

  
}
