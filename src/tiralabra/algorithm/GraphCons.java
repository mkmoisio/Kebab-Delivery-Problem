/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.algorithm;

import tiralabra.graph.Graph;
import tiralabra.graph.implementations.TwoLevelAdjacencyMatrix;

/**
 *
 * @author mikkomo
 */
public class GraphCons {

    public static TwoLevelAdjacencyMatrix constructSignificantGraph(Graph inputGraph, int[] significantVertice) {

        int[][] dist = inputGraph.getAdjacencyMatrix();
        int[][] significantGraph = new int[significantVertice.length][significantVertice.length];
        int[][] originalNodeNumbers = new int[significantVertice.length][significantVertice.length];

        for (int i = 0; i < significantVertice.length; i++) {
            for (int j = 0; j < significantVertice.length; j++) {
                if (i == j) {
                    significantGraph[i][j] = -1;
                } else {
                    significantGraph[i][j] = dist[significantVertice[i]][significantVertice[j]];
                    originalNodeNumbers[i][j] = significantVertice[i];
                }
            }
        }
        return new TwoLevelAdjacencyMatrix(significantGraph, originalNodeNumbers);
    }

}
