/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.algorithm;

import tiralabra.graph.Graph;
import tiralabra.graph.Node;
import tiralabra.graph.implementations.PathAdjacencyMatrix;
import tiralabra.graph.utils.AlgorithmResult;
import tiralabra.graph.utils.PathResult;

/**
 *
 * @author mikkomo
 */
public class DeliveryPathSolver {

    BellmanHeldKarpRecursion TSPsolver;
    FloydWarshall FWSolver;

    public DeliveryPathSolver() {
        TSPsolver = new BellmanHeldKarpRecursion();
        FWSolver = new FloydWarshall();
    }

    ;   
    
    public PathResult solvePath(Graph graph, int[] pointsToVisit) {
        PathResult result = new PathResult("Delivery Path Solver");
        result.start();

        PathAdjacencyMatrix shortestPaths = FWSolver.allShortestPaths(graph);

        AlgorithmResult tspResult = this.TSPsolver.solveTSPpathS(shortestPaths, pointsToVisit);

        Node node = tspResult.getStartNode();

        result.setStartNode(node);

        while (node != null) {
            node.setRequired();
            node.setName(graph.getName(node.getValue()));
            node = FWSolver.reconstructPath(shortestPaths, node);
        }
        result.end();
        result.addSubResult(FWSolver.getResult());
        result.addSubResult(tspResult);
        return result;
    }

}
