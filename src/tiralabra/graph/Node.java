/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph;

import java.util.List;

/**
 *
 * @author mikkomo
 */
public abstract class  Node {
    
    private String name;
    private int id;
    private List<Node> neighbors;
    
    public void addNeighbor(Node node) {
        
    }
    
}
