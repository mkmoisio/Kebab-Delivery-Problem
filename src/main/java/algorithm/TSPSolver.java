/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import graph.Graph;
import graph.utils.AlgorithmResult;

/**
 *
 * @author mikkomo
 */
public interface TSPSolver {
    
  //   public int solveTSP(Graph G);
     
     public AlgorithmResult solveTSPpath(Graph graph, int[] pointsToVisit);
     
     public AlgorithmResult solveTSPpath(Graph graph);
}
