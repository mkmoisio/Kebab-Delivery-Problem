package graph.utils;

import graph.implementations.PathAdjacencyMatrix;

/**
 *
 * @author mikkomo
 */
public class FloydWarshallResult extends Result {

    private PathAdjacencyMatrix matrix;

    public FloydWarshallResult(String algorithm) {
        super(algorithm);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Algorithm: ").append(super.getAlgorithm()).append("\n");
        sb.append("Running time: ").append(super.getRunningTimeMs()).append(" ms \n");

        return sb.toString();
    }

    public PathAdjacencyMatrix getMatrix() {
        return matrix;
    }

    public void setMatrix(PathAdjacencyMatrix matrix) {
        this.matrix = matrix;
    }

}
