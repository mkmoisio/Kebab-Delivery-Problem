/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.algorithm;

import tiralabra.graph.Graph;
import tiralabra.graph.utils.PathResult;

/**
 *
 * @author mikkomo
 */
public interface TSPSolver {
    
  //   public int solveTSP(Graph G);
     
     public PathResult solveTSPpath(Graph G);
}
