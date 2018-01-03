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

   private Node prv;
   private Node nxt;
   private int value;
   private int fullPathLen;

    public Node(int value) {
        this.value = value;
    }

    public Node getPrv() {
        return prv;
    }

    public void setPrv(Node prv) {
        this.prv = prv;
    }

    public Node getNxt() {
        return nxt;
    }

    public void setNxt(Node nxt) {
        this.nxt = nxt;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getFullPathLen() {
        return fullPathLen;
    }

    public void setFullPathLen(int fullPathLen) {
        this.fullPathLen = fullPathLen;
    }

    
    
}
