/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.algorithm;

import tiralabra.graph.Graph;
import tiralabra.graph.implementations.PathAdjacencyMatrix;
import tiralabra.graph.implementations.TwoLevelAdjacencyMatrix;

/**
 *
 * @author mikkomo
 */
public class GraphCons {

    public  static Graph constructSignificantGraph(Graph origGraph, int[] significantVertice) {

        int[][] dist = origGraph.getAdjacencyMatrix();
        int[][] sigMatrix = new int[significantVertice.length][significantVertice.length];
        int[][] originalNodeNumbers = new int[significantVertice.length][significantVertice.length];

        for (int i = 0; i < significantVertice.length; i++) {
            for (int j = 0; j < significantVertice.length; j++) {
                if (i == j) {
                    sigMatrix[i][j] = -1;
                } else {
                    sigMatrix[i][j] = dist[significantVertice[i]][significantVertice[j]];

                }
            }
        }
        return new TwoLevelAdjacencyMatrix(sigMatrix, originalNodeNumbers);
    }

}
