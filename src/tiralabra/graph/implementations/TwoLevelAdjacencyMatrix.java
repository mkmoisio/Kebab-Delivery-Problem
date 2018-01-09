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
public class TwoLevelAdjacencyMatrix implements Graph {

    private AdjacencyMatrix matrix;
    private int[][] originalNodeNumber;

    public TwoLevelAdjacencyMatrix(int[][] matrix, int[][] origNumbers) {
        this.matrix = new AdjacencyMatrix(matrix);
        this.originalNodeNumber = origNumbers;
    }

    @Override
    public int cost(int x, int y) {
        return this.matrix.cost(x, y);
    }

    @Override
    public int getSize() {
        return this.matrix.getSize();
    }

    @Override
    public String[] getNodeNames() {
        return null;
    }

    @Override
    public int[][] getAdjacencyMatrix() {
        return this.matrix.getAdjacencyMatrix();
    }
    
    public int[][] GetOriginalNodeNumber() {
        return this.originalNodeNumber;
    }
}
