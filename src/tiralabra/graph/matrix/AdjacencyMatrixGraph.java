/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph.matrix;

import tiralabra.graph.Graph;
import tiralabra.graph.Node;

/**
 *
 * @author mikkomo
 */
public class AdjacencyMatrixGraph implements Graph {

    private final int[][] adjacencyMatrix;
    private int[][] path;

    public AdjacencyMatrixGraph(int[][] matrix) {
        this.adjacencyMatrix = matrix;
    }



    public Node getShortestPath(int[] nodes) {
        int[][] significant = this.constructSignificantGraph(nodes);
        

        return new Node("", 0, 0);
    }
    
    

    private int[][] constructSignificantGraph(int[] significantVertice) {

        int[][] dist = allShortestPathsBetweenTwoVerticesAsMatrix();
        int[][] sigMatrix = new int[significantVertice.length][significantVertice.length];

        for (int i = 0; i < significantVertice.length; i++) {
            for (int j = 0; j < significantVertice.length; j++) {
                sigMatrix[i][j] = dist[significantVertice[i]][significantVertice[j]];
            }
        }
        return sigMatrix;
    }

    /*
     F-W
     */
    private int[][] allShortestPathsBetweenTwoVerticesAsMatrix() {
        int[][] dist = this.clone2DArray(this.adjacencyMatrix);
        this.path = new int[dist.length][dist.length];
        for (int k = 0; k < dist.length; k++) {
            for (int i = 0; i < dist.length; i++) {
                for (int j = 0; j < dist.length; j++) {

                    int before = dist[i][j];
                    dist[i][j] = this.minDist(dist[i][j], dist[i][k], dist[k][j]);
                    if (dist[i][j] != before) {
                        this.path[i][j] = dist[i][k];
                    }
                }
            }
        }
        return dist;
    }

    private int minDist(int a, int b, int c) {
        if (b < 0 || c < 0) {
            return a;

        }
        if (a < 0) {
            return b + c;
        }

        return Math.min(a, b + c);
    }

    private int[][] clone2DArray(int[][] src) {
        int[][] dst = new int[src.length][src.length];

        for (int i = 0; i < src.length; i++) {
            System.arraycopy(src[i], 0, dst[i], 0, src.length);
        }
        return dst;
    }

    @Override
    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

}
