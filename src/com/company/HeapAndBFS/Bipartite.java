package com.company.HeapAndBFS;

import java.util.*;

public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        HashMap<GraphNode,Integer> visit=new HashMap<>();
        for(GraphNode node:graph){
            if(!isBFS(node,visit)){
                return false;
            }
        }

        return true;
    }

    private boolean isBFS(GraphNode node, HashMap<GraphNode, Integer> visit) {
        if(visit.containsKey(node)){
            return true;
        }
        Queue<GraphNode> queue=new LinkedList<>();
        queue.offer(node);
        visit.put(node,0);
        while(!queue.isEmpty()){
            GraphNode cur=queue.poll();
            int curGroup=visit.get(cur);
            int neighborGroup;
            if(curGroup==0){
                neighborGroup=1;
            }
            else{
                neighborGroup=0;
            }
            for(GraphNode neighbor:cur.neighbors){
                if(!visit.containsKey(neighbor)){
                    visit.put(neighbor,neighborGroup);
                    queue.offer(neighbor);
                }
                else if(visit.get(neighbor)!=neighborGroup){
                    return false;
                }
            }
        }
        return true;
    }

}
