package com.company.RecursionWithBT;

import com.company.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaxPathSumFromRootToLeaf {
    public int maxPathSumLeafToRoot(TreeNode root) {
        int[] globalMax=new int[]{Integer.MIN_VALUE};
        List<Integer> pathPrefix=new ArrayList<>();
        helper(root,pathPrefix,globalMax);
        return globalMax[0];
    }

    public int maxPathSumDownLeafToRoot(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return root.key;
        }
        if(root.left==null||root.right==null){
            return root.left==null?root.key+maxPathSumDownLeafToRoot(root.right):root.key+maxPathSumDownLeafToRoot(root.left);
        }
        return root.key+Math.max(maxPathSumDownLeafToRoot(root.left),maxPathSumDownLeafToRoot(root.right));
    }

    private void helper(TreeNode root, List<Integer> pathPrefix, int[] globalMax) {
        if(root==null){
            return;
        }
        if(root.left==null||root.right==null){
            globalMax[0]=Math.max(globalMax[0], sum(pathPrefix)+root.key);
        }
        pathPrefix.add(root.key);
        helper(root.left,pathPrefix,globalMax);
        helper(root.right,pathPrefix,globalMax);
        pathPrefix.remove(pathPrefix.size()-1);
    }

    private int sum(List<Integer> pathPrefix) {
        int sum=0;
        for (int i = 0; i < pathPrefix.size(); i++) {
            sum+=pathPrefix.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxPathSumFromRootToLeaf s=new MaxPathSumFromRootToLeaf();
        TreeNode root=new TreeNode(7);
        root.left=new TreeNode(3);
        root.right=new TreeNode(-13);
        root.left.left=new TreeNode(-6);
//        root.left.right=new TreeNode(-4);
        System.out.println(s.maxPathSumDownLeafToRoot(root));
    }
}
