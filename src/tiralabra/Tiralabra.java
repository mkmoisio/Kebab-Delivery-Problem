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
import tiralabra.algorithm.BellmanHeldKarp;
import tiralabra.graph.Graph;
import tiralabra.graph.maps.TestGraph;
import tiralabra.graph.matrix.AdjacencyMatrixGraph;
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
        Graph G = new AdjacencyMatrixGraph(TestGraph.c);
        BellmanHeldKarp BHK = new BellmanHeldKarp();
        System.out.println(BHK.solveTSP(G));
//        contents.forEach(System.out::println);
   
    }
    
}
