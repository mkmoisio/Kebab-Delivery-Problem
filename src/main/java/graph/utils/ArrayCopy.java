/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.utils;

/**
 *
 * @author mikkomo
 */
public class ArrayCopy {

    public static int[][] clone2DArray(int[][] src) {
        int[][] dst = new int[src.length][src.length];

        for (int i = 0; i < src.length; i++) {
            System.arraycopy(src[i], 0, dst[i], 0, src.length);
        }
        return dst;
    }
    
//     public static int[][][] clone2DArrayTo3D(int[][] src) {
//        int[][][] dst = new int[src.length][src.length][2];
//        
//        for (int i = 0; i < src.length; i++) {
//            for (int j = 0; j < src.length; j++) {
//                dst[i][j][0] = src[i][j];
//            }
//        }
//        
//        return dst;
//    }
}
