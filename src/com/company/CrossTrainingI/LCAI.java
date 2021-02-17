package com.company.CrossTrainingI;

import com.company.BinaryTree.TreeNode;

public class LCAI {
    public TreeNode lca(TreeNode root, int p, int q) {
        if(root==null||root.key==p||root.key==q){
            return root;
        }
        TreeNode left=lca(root.left,p,q);
        TreeNode right=lca(root.right,p,q);
        if(left!=null&&right!=null){
            return root;
        }
        return root.left==null?right:left;
    }
}
