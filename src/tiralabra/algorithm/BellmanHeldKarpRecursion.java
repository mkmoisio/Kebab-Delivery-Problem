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
public class BellmanHeldKarpRecursion implements BellmanHeldKarp {

    Graph G;
    private int curMin;

//    /**
//     * Solves the TSP for the given Graph. Only returns the distance of the
//     * shortest path.
//     *
//     * @param G
//     * @return
//     */
//    @Override
//    public int solveTSP(Graph G) {
//        this.G = G;
//        Set set = new Set();
//        for (int i = 1; i < G.getSize(); i++) {
//            set.add(i);
//        }
//        this.curMin = -1;
//        this.minPathV(0, 0, set);
//        return this.curMin;
//    }
    /**
     * Solves the TSP for the given Graph. Returns a Result object containing
     * data related to running the algorithm.
     *
     * @param G
     * @return Result
     */
    @Override
    public Result solveTSPpath(Graph G) {

        Result result = new Result();
        result.setAlgorithm("BellmanHeldKarp with Recursion");
        this.G = G;

        Set set = new Set();
        for (int i = 1; i < G.getSize(); i++) {
            set.add(i);
        }
        this.curMin = -1;
        result.setNodeCount(set.getSize() + 1);
        result.start();
        Node startingNode = this.minPath(0, 0, set);
        result.end();
        result.setStartNode(startingNode);
        result.setShortestPathLength(this.curMin);
        return result;
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
//            this.curMin = Maths.min(this.curMin, cCost + G.cost(i, 0));
//            return G.cost(i, 0);
//
//        } else {
//            int min = -1;
//
//            for (int j : set.asArray()) {
//                min = Maths.min(min, G.cost(i, j) + minPath(cCost + G.cost(i, j), j, set.remove(j)));
//
//            }
//            return min;
//        }
//
//    }
//
    private Node minPath(int curCost, int i, Set set) {
        if (Maths.min(curCost, curMin) == curMin) {
            return null;
        }

        if (set.isEmpty()) {
            int thisPath = curCost + G.cost(i, 0);
            if (this.curMin == Maths.min(curMin, thisPath)) {
                return null;
            } else {
                this.curMin = thisPath;
                Node lastNode = new Node(0);

                Node secondLast = new Node(i);
                secondLast.setNext(lastNode);
                return secondLast;
            }

        } else {
            Node n = null;
            for (int j : set.asArray()) {
                Node tmpNode = minPath(curCost + G.cost(i, j), j, set.remove(j));
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
