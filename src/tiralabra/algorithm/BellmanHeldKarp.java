/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import tiralabra.graph.Graph;
import tiralabra.graph.Node;
import tiralabra.graph.Set;

/**
 *
 * @author mikkomo
 */
public class BellmanHeldKarp {

    Graph G;

   public BellmanHeldKarp() {

    }

    public int solveTSP(Graph G) {
        this.G = G;
        Set set = new Set();
        for (int i = 1; i < G.getSize(); i++) {
            set.add(i);
        }
        System.out.println(set.getSize());
        System.out.println(set.toString());
        int i = this.minPath(0, set);
        this.G = null;
        return i;
    }

    /**
     *
     *
     * @param i dst
     * @param s Set on points to visit
     * @return minimum length from point 1 to point i that visits all points in
     * set s.
     */
    private int minPath(int i, Set set) {
        if (set.isEmpty()) {
            return G.cost(i, 1);
        } else {
            int min = Integer.MAX_VALUE;

            System.out.println(Arrays.toString(set.asArray()));
            for (int j : set.asArray()) {
                min = Math.min(min, G.cost(i, j) + minPath(j, set.remove(j)));
            }
            return min;
        }
    }

}
