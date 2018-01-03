/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.algorithm;

import java.util.LinkedList;
import tiralabra.graph.Graph;
import tiralabra.graph.Node;
import tiralabra.graph.Set;
import tiralabra.graph.utils.Maths;

/**
 * Recursive implementation of Bellman-Held-Karp algorithm as described in
 * http://www.mafy.lut.fi/study/DiscreteOpt/tspdp.pdf
 *
 * @author mikkomo
 */
public class BellmanHeldKarpRecursion implements BellmanHeldKarp {

    Graph G;
    private int curMin;
    LinkedList<Integer> list;

    @Override
    public int solveTSP(Graph G) {
        list = new LinkedList();
        this.G = G;
        Set set = new Set();
        for (int i = 1; i < G.getSize(); i++) {
            set.add(i);
        }
        this.curMin = -1;
        this.minPathV(0, 0, set);
        this.G = null;
        return this.curMin;
    }
    
    /**
     * Solves the TSP for the given Graph. 
     * @param G 
     * @return the start node of the shortest path
     */
    @Override
     public Node solveTSPpath(Graph G) {
        this.G = G;
        Set set = new Set();
        for (int i = 1; i < G.getSize(); i++) {
            set.add(i);
        }
        this.curMin = -1;
        Node n = this.minPathN(0, 0, set);
        n.setFullPathLen(this.curMin);
        this.G = null;
        return n;
    }

    /**
     *
     *
     * @param i dst
     * @param s Set on points to visit
     * @return minimum length from point 1 to point i that visits all points in
     * set s.
     */
    private int minPath(int cCost, int i, Set set) {
        if (Maths.min(cCost, curMin) == curMin) {
            return -1;
        }

        if (set.isEmpty()) {
            this.curMin = Maths.min(this.curMin, cCost + G.cost(i, 0));
            return G.cost(i, 0);

        } else {
            int min = -1;

            for (int j : set.asArray()) {
                min = Maths.min(min, G.cost(i, j) + minPath(cCost + G.cost(i, j), j, set.remove(j)));

            }
            return min;
        }

    }

    /**
     *
     *
     * @param i dst
     * @param s Set on points to visit
     * @return minimum length from point 1 to point i that visits all points in
     * set s.
     */
    private void minPathV(int cCost, int i, Set set) {
        if (Maths.min(cCost, curMin) == curMin) {
            return;
        }

        if (set.isEmpty()) {
            this.curMin = Maths.min(this.curMin, cCost + G.cost(i, 0));

        } else {

            for (int j : set.asArray()) {
                minPathV(cCost + G.cost(i, j), j, set.remove(j));

            }

        }

    }

    private Node minPathN(int curCost, int i, Set set) {
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
                 secondLast.setNxt(lastNode);
                 return secondLast;
            }

        } else {
            Node n = null;
            for (int j : set.asArray()) {
                Node tmpNode = minPathN(curCost + G.cost(i, j), j, set.remove(j));
                if (tmpNode != null) {
                    n = tmpNode;
                }
            }
            if (n != null) {
                Node currentNode = new Node(i);
                currentNode.setNxt(n);
                return currentNode;
            }
            return null;
        }

    }

}
