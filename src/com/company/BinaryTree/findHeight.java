package com.company.BinaryTree;

public class findHeight {
    public int findHeight(TreeNode root) {
        int height=0;
        if(root==null){
            return height;
        }
        return Math.max(findHeight(root.left),findHeight(root.right))+1;
    }
}
