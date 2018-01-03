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

/**
 *
 * @author mikkomo
 */
public class AdjacencyMatrixGraph implements Graph {

    private final int[][] adjacencyMatrix;
    private int[][] path;
    private  int nodeCount;
    /**
     * Luo graafin matriisiesityksen annetusta
     * @param matrix
     */
    public AdjacencyMatrixGraph(int[][] matrix) {
        this.adjacencyMatrix = matrix;
        this.nodeCount = matrix.length;
    }
    
    public int getSize() {
        return this.adjacencyMatrix.length;
    }

    @Override
    public int getNodeCount() {
        return this.nodeCount;
    }
    /**
     * Laskee mikä on tämän graafin sellainen lyhin polku, joka käy parametrina annotuissa solmuissa ja palaa lähtösolmuun.
     * Lähtösolmu on parametrinä annettavan taulukon ensimmäinen alkio.
     * @param nodes solmut joissa käyvä lyhin polku halutaan
     * @return Polku solmuina
     */
    public Node getShortestPath(int[] nodes) {
        int[][] significant = this.constructSignificantGraph(nodes);

        return new Node(0);
    }

    private void solveTSP(int[][] significant) {
        int n = significant.length;

        List<SetNode> subsets = new ArrayList();

        subsets.add(new SetNode(1, 1, 0));

        for (int k = 1; k < n; n++) {

        }
        Set<Integer> S = new HashSet();

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
    
    /*
    Min(a, (b+c)), negatiiviset arvot = inf
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

    private int[][] clone2DArray(int[][] src) {
        int[][] dst = new int[src.length][src.length];

        for (int i = 0; i < src.length; i++) {
            System.arraycopy(src[i], 0, dst[i], 0, src.length);
        }
        return dst;
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
