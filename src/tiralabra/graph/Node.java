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

    private Node previous;
    private Node next;
    private int value;
    private String name;
    private int id;

    public Node(String name, int id, int value) {
        this.name = name;
        this.id = id;
        this.value = value;

    }

    public Node(int id, int value) {
        this("-", id, value);
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public Node getNext() {
        return next;
    }

    public int getValue() {
        return value;
    } 

    public Node monista() {
        return new Node(this.getId(), this.getValue());
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
