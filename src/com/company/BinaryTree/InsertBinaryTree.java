package com.company.BinaryTree;

public class InsertBinaryTree {
    public TreeNode insert(TreeNode root, int key) {
        TreeNode newNode=new TreeNode(key);
        if(root==null){
            return newNode;
        }
        TreeNode cur=root;
        while(cur.key!=key){
            if(cur.key>key){
                if(cur.left!=null){
                    cur=cur.left;
                }
                else{
                    cur.left=newNode;
                    break;
                }
            }
            else{
                if(cur.right!=null){
                    cur=cur.right;
                }
                else{
                    cur.right=newNode;
                    break;
                }
            }
        }
        return root;
    }

    public TreeNode insert1(TreeNode root, int key) {
        if(root==null){
            TreeNode newNode=new TreeNode(key);
            return newNode;
        }
        if(root.key>key){
            root.left=insert1(root.left,key);
        }
        else if(root.key<key){
            root.right=insert1(root.right,key);
        }
        return root;
    }

    public static void main(String[] args) {
        InsertBinaryTree s=new InsertBinaryTree();
        TreeNode L1=new TreeNode(5);
        TreeNode L2=new TreeNode(4);
        TreeNode L3=new TreeNode(6);
        L1.left=L2;
        L1.right=L3;
        TreeNode result=s.insert1(L1,3);
        System.out.println(result);
    }
}
