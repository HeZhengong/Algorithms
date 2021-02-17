package com.company.CrossTrainingI;

import com.company.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class ClosetKNumberInBST {
    public int[] closestKValues(TreeNode root, double target, int k) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            queue.offer(helper(root));
        }
        int[] result=new int[queue.size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=queue.poll().key;
        }
        return result;
    }

    private TreeNode helper(TreeNode root) {
        if(root.left==null){
            return root;
        }
        if(root==null){
            return helper(root.right);
        }
        return helper(root.left);
    }

}
