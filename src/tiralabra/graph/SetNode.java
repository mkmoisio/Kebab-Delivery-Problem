/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mikkomo
 */
public class SetNode {
    
   private int to;
   private Set<Integer> s;
   private int value;

    public SetNode(Set<Integer> s, int i, int value) {
        this.to = i;
        this.s = s;
        this.value = value;
    }
    
    public SetNode(int s, int i, int value) {
        this.to = i;
        this.s = new HashSet();
        this.s.add(s);
        this.value = value;
    }

    public int getI() {
        return to;
    }

    public Set<Integer> getS() {
        return s;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    

           
           
           
           
}
