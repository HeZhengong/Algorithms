package com.company.CrossTrainingII;

import com.company.StackAndQueue.CircularDeque;

import java.util.*;

public class DeepCopyUndirectedGraph {
    public class Solution {
        public List<GraphNode> copy(List<GraphNode> graph) {
            List<GraphNode> newGraph=new ArrayList<>();
            Queue<GraphNode> queue = new ArrayDeque<>();
            HashMap<GraphNode,GraphNode> collect=new HashMap<>();
            for (GraphNode node:graph) {
                collect.put(node, new GraphNode(node.key));
                queue.offer(node);
                newGraph.add(collect.get(node));
            }
            while(!queue.isEmpty()){
                GraphNode old=queue.poll();
                for(GraphNode neighbor:old.neighbors){
                    if(collect.get(neighbor)==null){
                        collect.put(neighbor,new GraphNode(neighbor.key));
                        queue.offer(neighbor);
                    }
                    collect.get(old).neighbors.add(collect.get(neighbor));
                }
            }
            return newGraph;
        }
    }
}

class GraphNode {
   public int key;
   public List<GraphNode> neighbors;
   public GraphNode(int key) {
     this.key = key;
     this.neighbors = new ArrayList<GraphNode>();
   }
}
