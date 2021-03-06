/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.utils;

import graph.Node;

/**
 *
 * @author mikkomo
 */
public class PathResult extends Result {

    private Node startNode;
    private int shortestPathLength;

    public PathResult(String algorithm) {
        super(algorithm);
    }

    public int getShortestPathLength() {
        return shortestPathLength;
    }

    public void setShortestPathLength(int shortestPathLength) {
        this.shortestPathLength = shortestPathLength;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public Node getStartNode() {
        return startNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Algorithm: ").append(super.getAlgorithm()).append("\n");
        sb.append("Running time: ").append(super.getRunningTimeMs()).append(" ms \n");
        sb.append("The shortest path is: \n");
        Node node = this.getStartNode();

        while (node != null) {
            sb.append(node.toString());
            sb.append("\n");
            node = node.getNext();
        }
        sb.append(this.getShortestPathLength()).append(" meters.\n");

        if (super.getSubResults() != null) {
            for (Result r : super.getSubResults()) {
                sb.append(r.toString());
            }
        }
        return sb.toString();
    }

}
