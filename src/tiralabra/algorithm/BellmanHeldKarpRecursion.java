/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.algorithm;

import tiralabra.graph.Graph;
import tiralabra.graph.Set;

/**
 *
 * @author mikkomo
 */
public class BellmanHeldKarpRecursion implements BellmanHeldKarp {

    Graph G;


    @Override
    public int solveTSP(Graph G) {
        this.G = G;
        Set set = new Set();
        for (int i = 1; i < G.getSize(); i++) {
            set.add(i);
        }        

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
            return G.cost(i, 0);
            
        } else {
            int min = Integer.MAX_VALUE;
           
            for (int j : set.asArray()) {
                min = Math.min(min, G.cost(i, j) + minPath(j, set.remove(j)));
               
            }
            return min;
        }
    }

}
