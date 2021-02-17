package com.company.leetcode;

import com.company.BinaryTree.TreeNode;

import java.util.*;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        helper(root,result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode curResult=queue.poll();
                if(i==size-1){
                    result.add(curResult.key);
                }
                if(curResult.left!=null){
                    queue.offer(curResult.left);
                }
                if(curResult.right!=null){
                    queue.offer(curResult.right);
                }
            }
        }
    }
}
