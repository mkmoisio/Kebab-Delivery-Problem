/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph.utils;

import java.util.Arrays;
import java.util.List;
import tiralabra.graph.implementations.AdjacencyMatrix;

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
    public static AdjacencyMatrix adjacencyMatrixFromListOfStrings(List<String> list) {
        int[][] array2D = new int[list.size()][list.size()];
        String[] names = new String[list.size() +1];
       // System.out.println(list.size());
        for (int[] array1D : array2D) {
            Arrays.fill(array1D, -1);
        }
        
     
        list.forEach((String item) -> {
            int[] tmp = new int[list.size()];
            Arrays.fill(tmp, -1);
         //   System.out.println(item);
            String[] tmpString = item.split(":");
            
            int nodeNumber = Integer.parseInt(tmpString[0]);    
            names[nodeNumber] = tmpString[1];
            for (int i = 2; i < tmpString.length; i += 2) {
                
                tmp[Integer.parseInt(tmpString[i])] = Integer.parseInt(tmpString[i + 1]);
            }
            array2D[nodeNumber] = tmp;
          
        });
        
        
        
        for (int i = 0; i < list.size(); i++) {
            array2D[i][i] = 0;
        }
        AdjacencyMatrix mtrx = new AdjacencyMatrix(array2D, names);
        
        return mtrx;
    }
    
    /**
     * 2D-taulukon tulostus debuggaustarkoituksiin
     * @param array2D
     */
    public static void print2DArray(int[][] array2D) {
        for (int i = 0; i < array2D[0].length; i++) {
            System.out.print("[" + i + "]: ");
            System.out.println(Arrays.toString(array2D[i]));
        }
    }

  
}
