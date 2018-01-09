/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph;

/**
 *
 * @author mikkomo
 */
public class Node {

    private Node prev;
    private Node next;
    private int value;
    private String name;
    private boolean isRequired;

    public Node(int value) {
        this.value = value;
        this.isRequired = false;
        this.name = "unnamed";
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prv) {
        this.prev = prv;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRequired() {
        this.isRequired = true;
    }

    @Override
    public String toString() {
        return "Node [" + this.getValue() + "] " + this.getName() + " " + this.isRequired;
    }

}
