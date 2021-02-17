package com.company.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
    public class Solution {
        public List<Integer> postOrder(TreeNode root) {
            List<Integer> result=new ArrayList();
            helper(root, result);
            return result;
        }
        public void helper(TreeNode root, List<Integer> result){
            if(root==null){
                return;
            }
            helper(root.left, result);
            helper(root.right, result);
            result.add(root.key);
        }
    }

}
