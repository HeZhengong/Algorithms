package com.company.Recursion;

import com.company.BinaryTree.TreeNode;

public class StoreNumberOfNodeInLeftTree {
    public void numNodesLeft(TreeNodeLeft root) {
        helper(root);
    }

    private int helper(TreeNodeLeft root) {
        if(root==null){
            return 0;
        }
        int leftNum=helper(root.left);
        int rightNum=helper(root.right);
        root.numNodesLeft = leftNum;
        return leftNum+rightNum+1;
    }
}

class TreeNodeLeft{
    public int key;
    public TreeNodeLeft left;
    public TreeNodeLeft right;
    public int numNodesLeft;
    public TreeNodeLeft(int key){
        this.key=key;
    }
}
