/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph.maps;

/**
 *
 * @author mikkomo
 */
public class TestGraph {

    public static int[][] a = new int[][]{
        {0, 3, 2, 4, 3},
        {4, 0, 3, 6, 6},
        {5, 3, 0, 4, 4},
        {3, 5, 1, 0, 6},
        {5, 4, 2, 3, 0}
    };

    public static int[][] b = new int[][]{
        {0, 3, 2, 4, 3, 6, 3, 2, 4, 3, 5, 3, 2, 4},
        {4, 0, 3, 6, 6, 4, 3, 2, 4, 3, 3, 3, 2, 4},
        {5, 3, 0, 4, 4, 4, 3, 2, 4, 3, 5, 3, 2, 4},
        {3, 5, 1, 0, 6, 9, 3, 2, 4, 3, 5, 3, 2, 4},
        {5, 4, 2, 3, 0, 5, 3, 2, 4, 3, 1, 3, 2, 4},
        {5, 4, 2, 3, 0, 0, 3, 2, 4, 3, 9, 3, 2, 4},
        {3, 5, 1, 0, 6, 8, 0, 2, 4, 3, 6, 3, 2, 4},
        {3, 5, 1, 3, 6, 2, 3, 0, 4, 3, 4, 3, 2, 4},
        {3, 5, 1, 6, 6, 4, 3, 2, 0, 3, 2, 3, 2, 4},
        {3, 5, 1, 7, 6, 6, 3, 2, 4, 0, 0, 3, 2, 4},
        {3, 5, 1, 6, 6, 2, 3, 2, 4, 3, 0, 3, 2, 4},
        {3, 5, 1, 6, 6, 1, 3, 2, 4, 3, 5, 0, 2, 4},
        {3, 5, 1, 9, 6, 4, 3, 2, 4, 3, 3, 3, 0, 4},
        {3, 5, 1, 4, 6, 5, 3, 2, 4, 3, 7, 3, 2, 0},};

    public static int[][] c = new int[][]{
        {0, 2, 9, 10},
        {1, 0, 6, 4},
        {15, 7, 0, 8},
        {6, 3, 12, 0}
    };

}
