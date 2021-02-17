package com.company.leetcode;

import com.company.BinaryTree.TreeNode;

public class ConvertSortedArrayIntoBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if(l>r){
            return null;
        }
        int mid=l+(r-l)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,l,mid-1);
        root.right=helper(nums,mid+1,r);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArrayIntoBST s=new ConvertSortedArrayIntoBST();
        int[] nums={-10,-3,0,5,9};
        TreeNode result=s.sortedArrayToBST(nums);
        System.out.println(result);
    }

}
