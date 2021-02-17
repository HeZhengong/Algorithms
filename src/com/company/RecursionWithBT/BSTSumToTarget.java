package com.company.RecursionWithBT;

import com.company.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;



/*Given a binary tree in which each node contains an integer number.
        Determine if there exists a path (the path can only be from one node to itself or to any of its descendants),
        the sum of the numbers on the path is the given target number.*/
//1.
//2.
//3.
public class BSTSumToTarget {
    public boolean exist(TreeNode root, int target) {
        if(root==null){
            return false;
        }
        List<TreeNode> bstNode=new ArrayList<>();
        return helper(bstNode,root,target);
    }

    private boolean helper(List<TreeNode> bstNode, TreeNode root, int target) {
        bstNode.add(root);
        int tmp=0;
        for (int i = bstNode.size()-1; i >= 0; i--) {
            tmp+=bstNode.get(i).key;
            if(tmp==target){
                return true;
            }
        }
        if(root.left!=null&&helper(bstNode,root.left,target)){
            return true;
        }
        if(root.right!=null&&helper(bstNode,root.right,target)){
            return true;
        }

        bstNode.remove(bstNode.size()-1);
        return false;
    }
}
