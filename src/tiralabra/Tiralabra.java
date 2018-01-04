/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import java.io.IOException;
import tiralabra.algorithm.BellmanHeldKarpRecursion;
import tiralabra.graph.Graph;
import tiralabra.graph.maps.TestGraphs;
import tiralabra.graph.implementations.AdjacencyMatrix;
import tiralabra.graph.utils.Result;

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


        Graph G = new AdjacencyMatrix(TestGraphs.belgium, TestGraphs.belgiumNames);
        BellmanHeldKarpRecursion BHK = new BellmanHeldKarpRecursion();
        Result result = BHK.solveTSPpath(G);
        
        System.out.println(result.toString());
    }

}
