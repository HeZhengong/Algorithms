package com.company.BinaryTree;


import java.util.List;

public class DeleteNode {
    public TreeNode deleteTree(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.key < key) {
            root.right=deleteTree(root.right, key);
            return root;
        } else if (root.key > key) {
            root.left=deleteTree(root.left, key);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode newNode = min(root.right);
                newNode.right = deleteMin(root.right);
                newNode.left = root.left;
                return newNode;
            }
        }
    }

    private TreeNode deleteMin(TreeNode node) {
        if(node.left==null){
            return node.right;
        }
        else{
            node.left= deleteMin(node.left);
            return node;
        }
    }

    private TreeNode min(TreeNode node) {
        if(node.left==null){
            return node;
        }
        else{
            return min(node.left);
        }
    }

    public static void main(String[] args) {
        DeleteNode s=new DeleteNode();
        TreeNode L1=new TreeNode(5);
        TreeNode L2=new TreeNode(3);
        TreeNode L3=new TreeNode(6);
        TreeNode L4=new TreeNode(2);
        TreeNode L5=new TreeNode(4);
        TreeNode L6=new TreeNode(7);
        L1.left=L2;
        L2.left=L4;
        L2.right=L5;
        L1.right=L3;
        L3.right=L6;
        TreeNode result=s.deleteTree(L1,3);
        System.out.println(result);
    }
}
