/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import java.io.IOException;
import tiralabra.algorithm.BellmanHeldKarpRecursion;
import tiralabra.algorithm.FloydWarshall;
import tiralabra.algorithm.GraphCons;
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


        Graph original = new AdjacencyMatrix(TestGraphs.belgium, TestGraphs.belgiumNames);
        FloydWarshall fw = new FloydWarshall();
        Graph shortestPaths = fw.allShortestPaths(original);
        int[] townsToVisit = new int[]{1, 3, 5}; // aachen, sittard, echt
        
        Graph signiGraph = GraphCons.constructSignificantGraph(shortestPaths, townsToVisit);
        BellmanHeldKarpRecursion BHK = new BellmanHeldKarpRecursion();
        Result result = BHK.solveTSPpath(signiGraph);
        
        System.out.println(result.toString());
    }

}
