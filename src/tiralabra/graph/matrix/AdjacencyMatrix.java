/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tiralabra.graph.Graph;
import tiralabra.graph.Node;
import tiralabra.graph.SetNode;
import tiralabra.graph.utils.ArrayCopy;

/**
 *
 * @author mikkomo
 */
public class AdjacencyMatrix implements Graph {

    private final int[][] adjacencyMatrix;
    private int[][] path;
    private final int nodeCount;

    /**
     *
     * @param matrix
     */
    public AdjacencyMatrix(int[][] matrix) {
        this.adjacencyMatrix = matrix;
        this.nodeCount = matrix.length;
    }

    @Override
    public int getSize() {
        return this.adjacencyMatrix.length;
    }

    @Override
    public int getNodeCount() {
        return this.nodeCount;
    }

    private int[][] constructSignificantGraph(int[] significantVertice) {

        int[][] dist = allShortestPathsBetweenTwoVerticesAsMatrix();
        int[][] sigMatrix = new int[significantVertice.length][significantVertice.length];

        for (int i = 0; i < significantVertice.length; i++) {
            for (int j = 0; j < significantVertice.length; j++) {
                if (i == j) {
                    sigMatrix[i][j] = Integer.MAX_VALUE;
                } else {
                    sigMatrix[i][j] = dist[significantVertice[i]][significantVertice[j]];
                }
            }
        }
        return sigMatrix;
    }

    /*
     Laskee kaikki lyhimmät etäisyydet Floud-Warshallin algoritmilla ja palauttaa tuloksen 2-D matriisina.
     Lisäksi päivittää path-fieldiin polkua niin, että tarvittavat polut voidaan konstruoida myöhemmin
     */
    private int[][] allShortestPathsBetweenTwoVerticesAsMatrix() {
        int[][] dist = ArrayCopy.clone2DArray(this.adjacencyMatrix);
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

    /*
     Min(a, (b+c)), negatiiviset arvot = +inf
     */
    private int minDist(int a, int b, int c) {
        if (b < 0 || c < 0) {
            return a;

        }
        if (a < 0) {
            return b + c;
        }

        return Math.min(a, b + c);
    }

    // @Override
//    public int[][] getAdjacencyMatrix() {
//        return adjacencyMatrix;
//    }
    @Override
    public int cost(int x, int y) {
        return this.adjacencyMatrix[x][y];
    }

}
