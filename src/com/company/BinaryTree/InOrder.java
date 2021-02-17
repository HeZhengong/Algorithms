package com.company.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class InOrder {
    public List<Integer> InOrder(TreeNode root){
        List<Integer> result=new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if(root==null){
            return;
        }
        helper(root.left,result);
        result.add(root.key);
        helper(root.right,result);
    }

    public static void main(String[] args) {
        InOrder s=new InOrder();
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(11);

        List<Integer> result=s.InOrder(root);
        System.out.println(result);
    }
}
