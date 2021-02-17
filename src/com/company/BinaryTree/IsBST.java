package com.company.BinaryTree;

public class IsBST {
    public boolean isBST(TreeNode root) {
        long min=Long.MIN_VALUE;
        long max=Long.MAX_VALUE;
        boolean result=isBSTHelper(root,min,max);
        return result;
    }
    public boolean isBSTHelper(TreeNode root, long min, long max){
        if(root==null){
            return true;
        }
        if(root.key<=min||root.key>=max){
            return false;
        }
        return isBSTHelper(root.left,min,root.key)&&isBSTHelper(root.right,root.key,max);
    }
}
