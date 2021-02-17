package com.company.Recursion;

import com.company.BinaryTree.TreeNode;

public class LCAI {
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode one, TreeNode two) {
        if(root==null||root==one||root==two){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,one,two);
        TreeNode right=lowestCommonAncestor(root.right,one,two);
        if(left==null&&right==null){
            return null;
        }
        if(left==null||right==null){
            return left==null?right:left;
        }
        else {
            return root;
        }
    }
}
