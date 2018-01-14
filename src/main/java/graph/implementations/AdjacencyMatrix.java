package graph.implementations;

import graph.Graph;

/**
 *
 * @author mikkomo
 */
public class AdjacencyMatrix implements Graph {

    private final int[][] adjacencyMatrix;
    private final String[] nodeNames;

    /**
     *
     * @param matrix
     * @param names
     */
    public AdjacencyMatrix(int[][] matrix, String[] names) {
        this.adjacencyMatrix = matrix;
        this.nodeNames = names;
    }

    public AdjacencyMatrix(int[][] matrix) {
        this(matrix, null);
    }

    @Override
    public int getSize() {
        return this.adjacencyMatrix.length;
    }

    @Override
    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    @Override
    public int cost(int x, int y) {
        return this.adjacencyMatrix[x][y];
    }

    @Override
    public String[] getNames() {
        return nodeNames;
    }

    @Override
    public String getName(int i) {
        return this.getNames()[i];
    }

}
