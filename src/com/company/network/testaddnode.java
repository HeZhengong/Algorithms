package com.company.network;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.ArrayList;
import java.util.HashSet;





public class testaddnode{
    public static ArrayList<Node> allnodeList;
    public static ArrayList<String> dedupList;
//    public static ArrayList<Edge> alledgeList;
    ArrayList<String> data4 = new ArrayList<String>();
    //Default Network Constructor.
    ArrayList<Integer> allNodeDegree = new ArrayList<>();



    public testaddnode(){
        this.allnodeList = new ArrayList<>();
//        this.alledgeList = new ArrayList<>();
        this.dedupList =  new ArrayList<>();
    }

    public void addNode(String nodename){

        allnodeList.add(new Node(nodename));


    }
    public void dedup(ArrayList<Node> List) {
        for (Node node:allnodeList) {
            String NodeName = node.getNodeName();
            if(!dedupList.contains(NodeName)){
                dedupList.add(node.getNodeName());
            }
        }
    }

    public static void main(String[] args) {
        testaddnode networkshow = new testaddnode();
        networkshow.addNode("dd");
        networkshow.addNode("aa");
        networkshow.addNode("dd");
        networkshow.addNode("cc");
        networkshow.dedup(allnodeList);

        System.out.print(dedupList);

    }

}

