/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph.utils;

import tiralabra.graph.Graph;
import tiralabra.graph.Node;

/**
 *
 * @author mikkomo
 */
public class Result {

    private long runningTimeMs;
    private int shortestPathLength;
    private Node startNode;
    private String algorithm;
    private Graph graph;

    public void start() {
        this.runningTimeMs = System.currentTimeMillis();
    }

    public void end() {
        this.runningTimeMs = (System.currentTimeMillis() - this.runningTimeMs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Algorithm used: ").append(this.algorithm).append("\n");
        sb.append("Running time: ").append(this.runningTimeMs).append(" ms \n");
        sb.append("Graph size: ").append(this.graph.getSize()).append("\n");
        sb.append("Shortest path length: ").append(this.shortestPathLength).append("\n");
        sb.append("The shortest path is: ");
        Node node = this.startNode;
        String[] names = this.graph.getNodeNames();

        while (node != null) {
            if (names != null) {
                sb.append(names[node.getValue()]);
            } else {
                sb.append(node.getValue());

            }
            node = node.getNext();

            if (node != null) {
                sb.append("-");
            }

        }
        sb.append("\n");
        return sb.toString();
    }

    public void setShortestPathLength(int shortestPathLength) {
        this.shortestPathLength = shortestPathLength;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public int getShortestPathLength() {
        return shortestPathLength;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

}