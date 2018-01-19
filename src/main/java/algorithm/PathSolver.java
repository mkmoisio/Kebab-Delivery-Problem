package algorithm;

import graph.Graph;
import graph.Node;
import graph.utils.FloydWarshallResult;
import graph.utils.TSPResult;
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

        FloydWarshallResult fwr = FWSolver.allShortestPaths(graph);

        TSPResult tsp = this.TSPsolver.solveTSPpath(fwr.getMatrix(), pointsToVisit);

        Node node = tsp.getStartNode();

        result.setStartNode(node);

        while (node != null) {
            node.setRequired();
            node.setName(graph.getName(node.getValue()));
            node = FWSolver.reconstructPath(fwr.getMatrix(), node);
        }
        result.end();
        result.setShortestPathLength(tsp.getShortestPathLength());
        result.addSubResult(fwr);
        result.addSubResult(tsp);
        return result;
    }

}
