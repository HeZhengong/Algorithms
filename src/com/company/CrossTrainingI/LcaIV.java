package com.company.CrossTrainingI;

import com.company.BinaryTree.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LcaIV {
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        Set<TreeNode> set=new HashSet<>(nodes);
        return helper(root,set);
    }

    private TreeNode helper(TreeNode root, Set<TreeNode> set) {
        if(root==null){
            return null;
        }
        if(set.contains(root)){
            return root;
        }
        TreeNode left=helper(root.left,set);
        TreeNode right=helper(root.right,set);
        if(left!=null&&right!=null){
            return root;
        }
        return left==null?right:left;
    }
}
