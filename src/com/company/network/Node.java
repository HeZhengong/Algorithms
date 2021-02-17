package com.company.network;

public class Node {

    public String nodename;//contain the name of the node

    public Node() {
        this.nodename = ""; // default constructor that creates a node with an empty name
    }

    public Node(String nodename) {
        this.nodename = nodename; // constructor with a string argument that creates a node with the given name
    }

    public String toString() {
        return this.nodename;
    }

    public String getNodeName() {
        return nodename;
    }

    public void print(String nodename) {
        System.out.println(nodename);
    }
}
