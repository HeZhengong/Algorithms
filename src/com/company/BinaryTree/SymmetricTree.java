package com.company.BinaryTree;



public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        TreeNode left=root;
        TreeNode right=root;
        boolean result=helper(left,right);
        return result;
    }
    public boolean helper(TreeNode left, TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if(left.key!=right.key){
            return false;
        }
        return helper(left.left,right.right)&&helper(left.right,right.left);
    }

    public static void main(String[] args) {
        SymmetricTree s=new SymmetricTree();
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        boolean result=s.isSymmetric(root);
        System.out.println(result);
    }
}
