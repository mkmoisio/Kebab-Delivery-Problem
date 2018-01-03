/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import tiralabra.algorithm.BellmanHeldKarpRecursion;
import tiralabra.graph.Graph;
import tiralabra.graph.Node;
import tiralabra.graph.maps.TestGraph;
import tiralabra.graph.matrix.AdjacencyMatrix;
import tiralabra.graph.utils.UtilityMethods;

/**
 *
 * @author mikkomo
 */
public class Tiralabra {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

//        Path p = Paths.get("./helsinki.txt");
//        
//        List<String> contents = Files.readAllLines(p);
//        
//        int[][] test = new int[][]{
//            {2, 3},
//            {4, 5}   
//        };
        // System.out.println(Arrays.deepToString(TestGraph.c));
        Graph G = new AdjacencyMatrix(TestGraph.c);
        long l = System.currentTimeMillis();
        BellmanHeldKarpRecursion BHK = new BellmanHeldKarpRecursion();
        Node n = BHK.solveTSPpath(G);
        System.out.println(System.currentTimeMillis() - l + " ms");
        System.out.println("Length of shortest path: " + n.getFullPathLen());
        System.out.println("The path: ");
        while (n != null) {
            System.out.print(n.getValue() + " ");
            n = n.getNxt();
        }
//        contents.forEach(System.out::println);

    }

}
