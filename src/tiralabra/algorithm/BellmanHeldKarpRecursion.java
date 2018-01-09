package tiralabra.algorithm;

import tiralabra.graph.Graph;
import tiralabra.graph.Node;
import tiralabra.graph.Set;
import tiralabra.graph.utils.Maths;
import tiralabra.graph.utils.Result;

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
     * Solves the TSP for the given Graph. Returns a Result object containing
     * data related to running the algorithm.
     *
     * @param graph
     * @return Result
     */
    @Override
    public Result solveTSPpath(Graph graph) {

        Result result = new Result();
        result.setAlgorithm("BellmanHeldKarp with Recursion");
        this.graph = graph;

        Set set = new Set();
        for (int i = 1; i < graph.getSize(); i++) {
            set.add(i);
        }
        this.curMin = -1;
      
        result.start();
        Node startingNode = this.minPath(0, 0, set, 0);
        result.end();
        result.setGraph(this.graph);
        result.setStartNode(startingNode);
        result.setShortestPathLength(this.curMin);
        return result;
    }
    
     
    public Node solveTSPpathS(Graph graph, int[] pointsToVisit) {

        Result result = new Result();
        result.setAlgorithm("BellmanHeldKarp with Recursion");
        this.graph = graph;

        Set set = new Set(pointsToVisit);
      
        this.curMin = -1;
      
        result.start();
        Node startingNode = this.minPath(0, pointsToVisit[0], set.remove(pointsToVisit[0]), pointsToVisit[0]);
      // System.out.println(this.curMin);
        result.end();
        result.setGraph(this.graph);
        result.setStartNode(startingNode);
        result.setShortestPathLength(this.curMin);
        return startingNode;
    }

//    /**
//     *
//     *
//     * @param i dst
//     * @param s Set on points to visit
//     * @return minimum length from point 1 to point i that visits all points in
//     * set s.
//     */
//    private int minPath(int cCost, int i, Set set) {
//        if (Maths.min(cCost, curMin) == curMin) {
//            return -1;
//        }
//
//        if (set.isEmpty()) {
//            this.curMin = Maths.min(this.curMin, cCost + graph.cost(i, 0));
//            return graph.cost(i, 0);
//
//        } else {
//            int min = -1;
//
//            for (int j : set.asArray()) {
//                min = Maths.min(min, graph.cost(i, j) + minPath(cCost + graph.cost(i, j), j, set.remove(j)));
//
//            }
//            return min;
//        }
//
//    }
//
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
