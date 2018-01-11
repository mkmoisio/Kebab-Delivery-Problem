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
import tiralabra.algorithm.BellmanHeldKarpRecursion;
import tiralabra.algorithm.DeliveryPathSolver;
import tiralabra.algorithm.FloydWarshall;
import tiralabra.graph.Graph;
import tiralabra.graph.maps.TestGraphs;
import tiralabra.graph.implementations.AdjacencyMatrix;
import tiralabra.graph.implementations.PathAdjacencyMatrix;
import tiralabra.graph.utils.PathResult;
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

        Path p = Paths.get("./helsinki.txt");

        Graph helsinki = UtilityMethods.adjacencyMatrixFromListOfStrings(Files.readAllLines(p));

//        FloydWarshall fw = new FloydWarshall();
//        PathAdjacencyMatrix shortestPaths = fw.allShortestPaths(helsinki);
//       UtilityMethods.print2DArray(shortestPaths.getAdjacencyMatrix());
//        UtilityMethods.print2DArray(shortestPaths.getPaths());
        DeliveryPathSolver dps = new DeliveryPathSolver();
        PathResult result = dps.solvePath(helsinki, new int[]{107, 41});
        System.out.println(result.toString());
//        Graph belgium = new AdjacencyMatrix(TestGraphs.belgium, TestGraphs.belgiumNames);
//        FloydWarshall fw = new FloydWarshall();
//        PathAdjacencyMatrix shortestPaths = fw.allShortestPaths(belgium);
//        int[] townsToVisit = new int[]{1, 3, 5}; // aachen, sittard, echt
//
//        TwoLevelAdjacencyMatrix signiGraph = GraphCons.constructSignificantGraph(shortestPaths, townsToVisit);
//        BellmanHeldKarpRecursion BHK = new BellmanHeldKarpRecursion();
//        PathResult result = BHK.solveTSPpath(signiGraph);
//
//        System.out.println(result.toString());
//        Graph belgium = new AdjacencyMatrix(TestGraphs.belgium, TestGraphs.belgiumNames);
//        DeliveryPathSolver dps = new DeliveryPathSolver();
//        int[] pointsToVisit = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // maastricht, heerlen, bonn
//        PathResult result = dps.solvePath(belgium, pointsToVisit);
//        Graph simple = new AdjacencyMatrix(TestGraphs.belgium, TestGraphs.belgiumNames);
//        DeliveryPathSolver dps = new DeliveryPathSolver();
//         PathResult result = dps.solvePath(simple, new int[]{1, 3});
//        System.out.println(result.toString());
//        TwoLevelAdjacencyMatrix signiGraph = GraphCons.constructSignificantGraph(belgium, new int[]{1, 2, 4});
//        UtilityMethods.print2DArray(signiGraph.getAdjacencyMatrix());
//        UtilityMethods.print2DArray(signiGraph.GetOriginalNodeNumber());
    }

}
