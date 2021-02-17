package com.company.MidTerm;

import com.company.BinaryTree.TreeNode;

//三部曲：1：what do you expect from left child and right child?
//       2. what do you do in the current tree node?
//       3. what do you return back to the parent node?
public class MaxPathTree {
    public int findMax(TreeNode root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int[] globalMax=new int[1];  //Since Java is pass by value. IMPORTANT!
        globalMax[0] = Integer.MIN_VALUE; //Initialize the globalMax value.
        helper(root,globalMax);
        return globalMax[0];
    }

    public int helper(TreeNode root, int[] globalMax){
        if(root==null){
            return 0;
        }
        int left=helper(root.left,globalMax); //what we expect from the left child is the return value from the left child.
        int right=helper(root.right,globalMax); //what we expect from the right child is the return value from the right child.
        if(root.left!=null&&root.right!=null)  //if the root has both children
        {
            globalMax[0] = Math.max(globalMax[0],root.key+left+right);  //the operation on this node: add root value, left child value and right child value.
            return Math.max(left,right)+root.key; // what we need to return back to the parent node.
        }
        else{
            return root.left==null?(right+root.key):(left+root.key); // if left is empty, then we only need to add right child value and root value，vice versa.
        }
    }
}

//Time Complexity = O(n);
//Space Complexity = O(height);
