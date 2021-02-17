package com.company.CrossTrainingII;

import com.company.BinaryTree.TreeNode;
import com.company.RecursionWithBT.MaxSumPathIII;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ClosestKNumberInBST {
    public int[] closestKValues(TreeNode root, double target, int k) {
        int[] result=new int[k];
        PriorityQueue<TreeNode> pq=new PriorityQueue<>(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return Math.abs(o1.key-target)< Math.abs(o2.key-target)?-1:1;
            }
        });
        pq.add(root);
        //traverse the treeNode.
        for (int i = 0; i < result.length; i++) {
            result[i]=pq.poll().key;
        }
        return result;
    }
}
