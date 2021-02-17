package com.company.RecursionWithBT;

import com.company.BinaryTree.TreeNode;
// 1. left=maxPathSum(root.left) the same thing for the right.
// 2.max(cur.key,cur.key+left,cur.key+right)
// 3. return cur.key+Max(left,right)
public class MaxSumPathIII {
    public int maxPathSum(TreeNode root) {
        int[] globalMax=new int[]{Integer.MIN_VALUE};
        helper(root,globalMax);
        return globalMax[0];
    }

    private int helper(TreeNode root, int[] globalMax) {
        if(root==null){
            return 0;
        }
        int left=helper(root.left,globalMax);
        int right=helper(root.right,globalMax);
        if(left<=0&&right<=0){
            globalMax[0]=Math.max(globalMax[0],root.key);
        }
        else if(root.key>=0){
            globalMax[0]=Math.max(globalMax[0],left<right?root.key+right:root.key+left);
        }
        else{
            globalMax[0]=Math.max(globalMax[0],left<right?right:left);
        }
        return root.key+Math.max(left,right);
    }

    public static void main(String[] args) {
        MaxSumPathIII s=new MaxSumPathIII();
        TreeNode root=new TreeNode(-5);
        root.left=new TreeNode(2);
        root.right=new TreeNode(11);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(14);
        root.right.left=new TreeNode(-3);
        System.out.println(s.maxPathSum(root));
    }

}
