package com.company.BinaryTree;

public class checkBalanceTree {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int LeftHeight=findHeight(root.left);
        int RightHeight=findHeight(root.right);
        if(Math.abs(LeftHeight-RightHeight)>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public int findHeight(TreeNode root){
        int height=0;
        if(root==null){
            return 0;
        }
        return Math.max(findHeight(root.left),findHeight(root.right))+1;
    }
}
