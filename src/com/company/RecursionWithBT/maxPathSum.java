package com.company.RecursionWithBT;

import com.company.BinaryTree.TreeNode;

// 1. what do you want from the children's node? Math.max(cur.key, Math.max(cur.key+left, cur.key+right)).
// 2. what the operation is in this node? Math.max(cur.key,cur.key+left, cur.key+right, cur.key+left+right). update globalMax
// 3. what do you return back to the parent node? Math.max(cur.key, Math.max(cur.key+left, cur.key+right)).

public class maxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] globalMax= new int[1];
        globalMax[0]=Integer.MIN_VALUE;
        helper(root,globalMax);
        return globalMax[0];
    }

    private int helper(TreeNode root, int[] globalMax) {
        if(root==null){
            return 0;
        }
        int leftValue=helper(root.left,globalMax);
        int rightValue=helper(root.right,globalMax);
        if(leftValue<=0&&rightValue<=0){
            globalMax[0]=Math.max(globalMax[0],root.key);
        }
        else if(leftValue<=0||rightValue<=0){
            globalMax[0]=Math.max(globalMax[0],leftValue<=0?rightValue+root.key:leftValue+root.key);
        }
        else{
            globalMax[0]=Math.max(globalMax[0],leftValue+rightValue+root.key);
        }

        return Math.max(root.key,Math.max(root.key+leftValue,root.key+rightValue));
    }

    public static void main(String[] args) {
        maxPathSum s=new maxPathSum();
        TreeNode root=new TreeNode(-1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(11);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(-14);
        System.out.println(s.maxPathSum(root));
    }
}
