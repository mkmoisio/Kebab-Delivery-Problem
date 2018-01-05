/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph.implementations;

import tiralabra.graph.Graph;

/**
 *
 * @author mikkomo
 */
public class PathAdjacencyMatrix implements Graph {

    private AdjacencyMatrix matrix;
    private int[][] paths;

    public PathAdjacencyMatrix(int[][] matrix, int[][] paths) {
        this.matrix = new AdjacencyMatrix(matrix);
        this.paths = paths;
    }

    public int getPath(int x, int y) {
        return this.paths[x][y];
    }

    public int[][] getPaths() {
        return this.paths;
    }

    @Override
    public int cost(int x, int y) {
        return this.matrix.cost(x, y);
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getNodeNames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[][] getAdjacencyMatrix() {
        return this.matrix.getAdjacencyMatrix();
    }
}
