/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph.utils;

import tiralabra.graph.Node;

/**
 *
 * @author mikkomo
 */
public class PathResult extends Result {

    public PathResult(String algorithm) {
        super(algorithm);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Algorithm: ").append(super.getAlgorithm()).append("\n");
        sb.append("Running time: ").append(super.getRunningTimeMs()).append(" ms \n");
        sb.append("The shortest path is: \n");
        Node node = super.getStartNode();

        while (node != null) {
            sb.append(node.toString());
            sb.append("\n");
            node = node.getNext();
        }

        if (super.getSubResults() != null) {
            for (Result r : super.getSubResults()) {
                sb.append(r.toString());
            }
        }

        return sb.toString();
    }

}
