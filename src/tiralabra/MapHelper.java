/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import java.util.Arrays;

/**
 *
 * @author mikkomo
 */
public class MapHelper {

    
    public final static int NUMBER_OF_NODES = 70;

    public static int[] initArray(int[][] neighbors) {
        int[] array = new int[NUMBER_OF_NODES];

        for (int i = 0; i < NUMBER_OF_NODES; i++) {

        }
        return array;
    }

    public int[][] getMap(String witch) {
        if (witch.equals("helsinki")) {
            
            
            return this.hel;
        }
        return null;
    }

}
