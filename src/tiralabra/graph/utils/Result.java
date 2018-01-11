/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph.utils;

import java.util.ArrayList;
import java.util.List;
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
    private List<Result> subResults;

    
    public Result(String algorithm) {
        this.algorithm = algorithm;
    }
    public void start() {
        this.runningTimeMs = System.currentTimeMillis();
    }

    public void end() {
        this.runningTimeMs = (System.currentTimeMillis() - this.runningTimeMs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Algorithm: ").append(this.algorithm).append("\n");
        sb.append("Running time: ").append(this.runningTimeMs).append(" ms \n");
    //    sb.append("The shortest path is: ");
        Node node = this.startNode;

        while (node != null) {
            sb.append(node.toString());
            sb.append("\n");
            node = node.getNext();
        }

        if (this.subResults != null) {
            for (Result r : this.subResults) {
                sb.append(r.toString());
            }
        }

        return sb.toString();
    }

    public void setShortestPathLength(int shortestPathLength) {
        this.shortestPathLength = shortestPathLength;
    }

    public void addSubResult(Result result) {
        if (this.subResults == null) {
            this.subResults = new ArrayList();
        }
        this.subResults.add(result);
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

    public Node getStartNode() {
        return startNode;
    }

    

}
