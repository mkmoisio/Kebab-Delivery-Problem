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

    private AdjacencyMatrix adjMatrix;
    private int[][] paths;

    public PathAdjacencyMatrix(int[][] matrix, int[][] paths, String[] names) {
        this.adjMatrix = new AdjacencyMatrix(matrix, names);
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
        return this.adjMatrix.cost(x, y);
    }

    @Override
    public int getSize() {
        return this.adjMatrix.getSize();
    }

    @Override
    public String[] getNames() {
        return this.adjMatrix.getNames();
    }

    @Override
    public int[][] getAdjacencyMatrix() {
        return this.adjMatrix.getAdjacencyMatrix();
    }

    @Override
    public String getName(int i) {
        return this.getNames()[i];
    }
}
