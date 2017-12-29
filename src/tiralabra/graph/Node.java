/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph;

import java.util.Set;

/**
 *
 * @author mikkomo
 */
public class Node {

    private Set<Node> parents;
    private int value;

    public Node() {
        this(0);

    }

    public Node(int value) {
        this.value = value;
    }

}
