package com.company.BinaryTree;

import java.lang.annotation.Target;

public class SearchInBinaryTree {
    public TreeNode search(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root!=null&&root.key<key){
            return search(root.right,key);
        }
        else if(root!=null&&root.key==key){
            return root;
        }
        else{
            return search(root.left,key);
        }
    }
    public TreeNode search1(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root!=null&&root.key==key){
            return root;
        }
        else if(root!=null&&root.key<key){
            return search1(root.right,key);
        }
        else{
            return search1(root.left,key);
        }
    }

    public static void main(String[] args) {
        SearchInBinaryTree s=new SearchInBinaryTree();
        TreeNode L1=new TreeNode(2);
        TreeNode L2=new TreeNode(1);
        TreeNode L3=new TreeNode(3);
        L1.left=L2;
        L1.right=L3;
        TreeNode result=s.search1(L1,3);
        System.out.println(result.key);
    }
}
