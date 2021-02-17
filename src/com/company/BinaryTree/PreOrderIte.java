package com.company.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreOrderIte {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Deque<TreeNode> stack=new LinkedList<>();
        if(root==null){
            return result;
        }
        stack.offerFirst(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pollFirst();
            if(cur.right!=null){
                stack.offerFirst(cur.right);
            }
            if(cur.left!=null){
                stack.offerFirst(cur.left);
            }
            result.add(cur.key);
        }
        return result;
    }

    public static void main(String[] args) {
        PreOrderIte s=new PreOrderIte();
        TreeNode L1=new TreeNode(5);
        TreeNode L2=new TreeNode(3);
        TreeNode L3=new TreeNode(8);
        TreeNode L4=new TreeNode(1);
        TreeNode L5=new TreeNode(4);
        TreeNode L6=new TreeNode(11);
        L1.left=L2;
        L2.left=L4;
        L2.right=L5;
        L1.right=L3;
        L3.right=L6;
        List<Integer> result=s.preOrder(L1);
        System.out.println(result);
    }
}
