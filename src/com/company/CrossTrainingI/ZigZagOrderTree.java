package com.company.CrossTrainingI;

import com.company.BinaryTree.TreeNode;

import java.util.*;

public class ZigZagOrderTree {
    public List<Integer> zigZag(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        helper(root,result);
        return result;
    }

    public void helper(TreeNode root, List<Integer> result){
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        int level=0;
        while(!deque.isEmpty()){
            int size=deque.size();
                if(level%2==1){
                    for (int i = 0; i < size; i++) {
                        TreeNode curNode = deque.pollLast();
                        if (curNode.left != null) {
                            deque.offerFirst(curNode.left);
                        }
                        if (curNode.right != null) {
                            deque.offerFirst(curNode.right);
                        }
                        result.add(curNode.key);
                    }
                }
                else{
                    for (int j = 0; j < size; j++) {
                        TreeNode curNode = deque.pollFirst();
                        if (curNode.right != null) {
                            deque.offerLast(curNode.right);
                        }
                        if (curNode.left != null) {
                            deque.offerLast(curNode.left);
                        }
                        result.add(curNode.key);
                    }
                }
                level+=1;
            }
        }

    public static void main(String[] args) {
        ZigZagOrderTree s=new ZigZagOrderTree();
        TreeNode root= new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(11);
        System.out.println(s.zigZag(root));
    }
}
