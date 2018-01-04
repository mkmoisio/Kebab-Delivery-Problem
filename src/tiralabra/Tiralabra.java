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
import tiralabra.graph.maps.TestGraphs;
import tiralabra.graph.matrix.AdjacencyMatrix;
import tiralabra.graph.utils.Result;
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


        Graph G = new AdjacencyMatrix(TestGraphs.c);
        BellmanHeldKarpRecursion BHK = new BellmanHeldKarpRecursion();
        Result result = BHK.solveTSPpath(G);
        
        System.out.println(result.toString());
    }

}
