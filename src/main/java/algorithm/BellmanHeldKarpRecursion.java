package algorithm;

import graph.Graph;
import graph.Node;
import graph.utils.Set;
import graph.utils.AlgorithmResult;
import other.Maths;

/**
 * Recursive implementation of Bellman-Held-Karp algorithm as described in
 * http://www.mafy.lut.fi/study/DiscreteOpt/tspdp.pdf
 *
 * @author mikkomo
 */
public class BellmanHeldKarpRecursion implements TSPSolver {

    Graph graph;
    private int curMin;

    /**
     * Solves the TSP for all nodes the given Graph. Returns a PathResult object
     * containing data related to running the algorithm. Graph should have all
     * shortest paths.
     *
     * @param graph
     * @return PathResult
     */
    @Override
    public AlgorithmResult solveTSPpath(Graph graph) {

        int[] pointsToVisit = new int[graph.getSize()];

        for (int i = 0; i < pointsToVisit.length; i++) {
            pointsToVisit[i] = i;
        }

        return this.solveTSPpath(graph, pointsToVisit);
    }

    /**
     * Solves the TSP for the given points in the given graph. Returns a
     * PathResult object containing data related to running the algorithm
     * including running, shortest path length and starting node.
     *
     * @param graph
     * @param pointsToVisit
     * @return PathResult
     */
    @Override
    public AlgorithmResult solveTSPpath(Graph graph, int[] pointsToVisit) {

        AlgorithmResult result = new AlgorithmResult("BellmanHeldKarp with Recursion");
        this.graph = graph;

        Set set = new Set(pointsToVisit);

        this.curMin = -1;

        result.start();
        Node startingNode = this.minPath(0, pointsToVisit[0], set.remove(pointsToVisit[0]), pointsToVisit[0]);
        // System.out.println(this.curMin);
        result.end();
        result.setStartNode(startingNode);
        result.setShortestPathLength(this.curMin);
        return result;
    }

    /**
     *
     * @param curCost Current cumulative cost of the path
     * @param i Destination point
     * @param set A set of points to visit
     * @return
     */
    private Node minPath(int curCost, int i, Set set, int end) {
        if (Maths.min(curCost, curMin) == curMin) {
            return null;
        }

        if (set.isEmpty()) {
            int thisPath = curCost + graph.cost(i, end);
            if (this.curMin == Maths.min(curMin, thisPath)) {
                return null;
            } else {
                this.curMin = thisPath;
                Node lastNode = new Node(end);

                Node secondLast = new Node(i);
                secondLast.setNext(lastNode);
                return secondLast;
            }

        } else {
            Node n = null;
            for (int j : set.asArray()) {
                Node tmpNode = minPath(curCost + graph.cost(i, j), j, set.remove(j), end);
                if (tmpNode != null) {
                    n = tmpNode;
                }
            }
            if (n != null) {
                Node currentNode = new Node(i);
                currentNode.setNext(n);
                return currentNode;
            }
            return null;
        }

    }

}
