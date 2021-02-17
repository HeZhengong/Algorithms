package com.company.CrossTrainingII;

import com.company.BinaryTree.TreeNode;

public class ClosetNumberInBST {
    public int closest(TreeNode root, int target) {
        int globalMin=Integer.MAX_VALUE;
        TreeNode result=root;
        TreeNode cur=root;
        while(cur!=null){
            if(cur.key==target){
                return cur.key;
            }
            else if(cur.key<target){
                if(Math.abs(cur.key-target)<globalMin){
                    globalMin=Math.abs(cur.key-target);
                    result=cur;
                }
                cur=cur.right;
            }
            else{
                if(Math.abs(cur.key-target)<globalMin){
                    globalMin=Math.abs(cur.key-target);
                    result=cur;
                }
                cur=cur.left;
            }
        }
        return result.key;
    }

    public static void main(String[] args) {
        ClosetNumberInBST s=new ClosetNumberInBST();
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(2);
        root.right=new TreeNode(11);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(14);
        System.out.println(s.closest(root,10));
    }
}
