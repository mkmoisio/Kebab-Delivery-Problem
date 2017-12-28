/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph.matrix;

import tiralabra.graph.Graph;
import tiralabra.graph.Node;
import tiralabra.graph.Node;

/**
 *
 * @author mikkomo
 */
public class AdjacencyMatrixNodeGraph implements Graph {

    private final Node[][] adjacencyMatrix;

    public AdjacencyMatrixNodeGraph(int[][] m) {
        adjacencyMatrix = new Node[m.length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                adjacencyMatrix[i][j] = new Node(i, m[i][j]);
            }
        }
    }

    public Node[][] allShortestPathsBetweenTwoVerticesAsMatrix() {
        Node[][] dist = this.clone2DNodeArray(this.adjacencyMatrix);

        for (int k = 0; k < dist.length; k++) {
            for (int i = 0; i < dist.length; i++) {
                for (int j = 0; j < dist.length; j++) {
                    
                   // dist[i][j] = this.minDist(dist[i][j], dist[i][k], dist[k][j]);
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

    private Node[][] clone2DNodeArray(Node[][] src) {
        Node[][] dst = new Node[src.length][src.length];

        for (int i = 0; i < src.length; i++) {
            System.arraycopy(src[i], 0, dst[i], 0, src.length);
        }

        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src.length; j++) {
                dst[i][j] = src[i][j].monista();
            }

        }
        return dst;
    }

    public Graph constructSignificantGraph(int[] significantVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[][] getAdjacencyMatrix() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
