package com.company.BinaryTree;



import java.util.ArrayList;
import java.util.List;

public class getKeys {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> result=new ArrayList();
        helper(root,min,max,result);
        return result;
    }

    public void helper(TreeNode root, int min, int max, List<Integer>result){
        if(root==null){
            return;
        }
        if(root.key<=min){
            helper(root.right,min,max,result);
        }
        if(root.key>=max){
            helper(root.left,min,max,result);
        }
        if(max>root.key&&root.key>min){
            result.add(root.key);
            helper(root.left,min,max,result);
            helper(root.right,min,max,result);
        }
    }

    public static void main(String[] args) {
        getKeys s=new getKeys();
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(8);
        List<Integer> result=s.getRange(root,2,10);
        System.out.println(result);
    }
}
