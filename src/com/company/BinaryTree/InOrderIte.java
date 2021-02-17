package com.company.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InOrderIte {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Deque<TreeNode> stack=new LinkedList<>();
        if(root==null){
            return result;
        }
        TreeNode cur=root;
        while(!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.offerFirst(cur);
                cur=cur.left;
            }
            else{
                cur=stack.pollFirst();
                result.add(cur.key);
                cur=cur.right;
            }
        }
        return result;
    }
}
