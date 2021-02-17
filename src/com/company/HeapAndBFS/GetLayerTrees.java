package com.company.HeapAndBFS;

import com.company.BinaryTree.PostOrderIte;
import com.company.BinaryTree.TreeNode;

import java.util.*;

public class GetLayerTrees {
    public List<List<Integer>> layerByLayer(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        int layer=0;
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> curLayer=new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i <size ; i++) {
                TreeNode cur=queue.poll();
                curLayer.add(cur.key);
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            if(layer%2==0){
                result.add(curLayer);
            }
            else{
                Collections.reverse(curLayer);
                result.add(curLayer);
            }
            layer++;
//            result.add(curLayer);
        }
//        Collections.reverse(result);
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        int layer=0;
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
//        List<Integer> curResult=new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> curResult=new ArrayList<>();
//            queue.offer(root);
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(layer%2==0){
                    curResult.add(cur.key);
                    if(cur.right!=null){
                        queue.offer(cur.right);
                    }
                    if(cur.left!=null){
                        queue.offer(cur.left);
                    }
                }
                else{
                    curResult.add(cur.key);
                    if(cur.left!=null){
                        queue.offer(cur.left);
                    }
                    if(cur.right!=null){
                        queue.offer(cur.right);
                    }
                }
            }
            layer++;
            result.add(curResult);
        }
        return result;
    }
    public static void main(String[] args) {
        GetLayerTrees s=new GetLayerTrees();
        TreeNode L1=new TreeNode(5);
        TreeNode L2=new TreeNode(3);
        TreeNode L3=new TreeNode(8);
        TreeNode L4=new TreeNode(1);
        TreeNode L5=new TreeNode(4);
        TreeNode L6=new TreeNode(11);
        L1.left=L2;
        L2.left=L4;
        L2.right=L5;
        L1.right=L3;
        L3.right=L6;
        List<List<Integer>> result=s.layerByLayer(L1);
        List<List<Integer>> result1=s.zigzagLevelOrder(L1);
        System.out.println(result);
        System.out.println(result1);
    }
}
