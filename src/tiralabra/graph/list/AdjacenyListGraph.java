/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph.list;

import java.util.ArrayList;
import java.util.List;
import tiralabra.graph.Graph;
import tiralabra.graph.Node;

/**
 *
 * @author mikkomo
 */
public class AdjacenyListGraph implements Graph{
    
    
    private List<Node> list;
    AdjacenyListGraph() {
        list = new ArrayList();
        
    }
    
    public void addNode(Node node) {
        list.add(node);
    }
    
    
}
