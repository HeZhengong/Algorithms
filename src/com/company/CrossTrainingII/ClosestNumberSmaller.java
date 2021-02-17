package com.company.CrossTrainingII;

import com.company.BinaryTree.TreeNode;

public class ClosestNumberSmaller {
    public int largestSmaller(TreeNode root, int target) {
        int globalMin=Integer.MAX_VALUE;
        TreeNode result=new TreeNode(Integer.MIN_VALUE);
        TreeNode cur=root;
        while(cur!=null){
            if(cur.key>=target){
                cur=cur.left;
            }
            else{
                if((target-cur.key)< globalMin){
                    globalMin=target-cur.key;
                    result=cur;
                }
                cur=cur.right;
            }
        }
        return result.key;
    }

    public static void main(String[] args) {
        ClosestNumberSmaller s=new ClosestNumberSmaller();
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(2);
        root.right=new TreeNode(11);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(14);
        System.out.println(s.largestSmaller(root,22));
    }
}
