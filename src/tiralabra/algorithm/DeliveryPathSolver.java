/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.algorithm;

import tiralabra.graph.Graph;
import tiralabra.graph.Node;
import tiralabra.graph.implementations.PathAdjacencyMatrix;
import tiralabra.graph.utils.Result;

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
    
    public Result solvePath(Graph graph, int[] pointsToVisit) {
        Result result = new Result("Delivery Path Solver");
        result.start();

        PathAdjacencyMatrix shortestPaths = FWSolver.allShortestPaths(graph);

        Result tspResult = this.TSPsolver.solveTSPpathS(shortestPaths, pointsToVisit);

        Node node = tspResult.getStartNode();

        result.setStartNode(node);

        while (node != null) {
            node.setRequired();
            node = FWSolver.reconstructPath(shortestPaths, node);
        }
        result.end();
        result.addSubResult(FWSolver.getResult());
        result.addSubResult(tspResult);
        return result;
    }

}
