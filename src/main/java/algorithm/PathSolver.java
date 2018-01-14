package algorithm;

import graph.Graph;
import graph.Node;
import graph.implementations.PathAdjacencyMatrix;
import graph.utils.AlgorithmResult;
import graph.utils.PathResult;

/**
 *
 * @author mikkomo
 */
public class PathSolver {

    BellmanHeldKarpRecursion TSPsolver;
    FloydWarshall FWSolver;

    public PathSolver() {
        TSPsolver = new BellmanHeldKarpRecursion();
        FWSolver = new FloydWarshall();
    }

    /**
     * Ratkaisee koko sen lyhimmän polun joka täytyy kulkea, jotta kaikki
     * annetut solmut tulevat käydyiksi siten, että polku päättyy
     * lähtöpisteeseen.
     *
     * @param graph
     * @param pointsToVisit
     * @return
     */
    public PathResult solvePath(Graph graph, int[] pointsToVisit) {
        PathResult result = new PathResult("Path Solver");
        result.start();

        PathAdjacencyMatrix shortestPaths = FWSolver.allShortestPaths(graph);

        AlgorithmResult tspResult = this.TSPsolver.solveTSPpath(shortestPaths, pointsToVisit);

        Node node = tspResult.getStartNode();

        result.setStartNode(node);

        while (node != null) {
            node.setRequired();
            node.setName(graph.getName(node.getValue()));
            node = FWSolver.reconstructPath(shortestPaths, node);
        }
        result.end();
        result.setShortestPathLength(tspResult.getShortestPathLength());
        result.addSubResult(FWSolver.getResult());
        result.addSubResult(tspResult);
        return result;
    }

}
