package com.company.Final;



import java.util.HashMap;
import java.util.Map;

public class Cousins {
    Map<Integer, Integer> depth;
    Map<Integer, TreeNode1> parent;

    public boolean isCousins(TreeNode1 root, int x, int y) {
        depth = new HashMap();
        parent = new HashMap();
        dfs(root, null);
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }

    public void dfs(TreeNode1 node, TreeNode1 parents) {
        if (node != null) {
            depth.put(node.key, parents != null ? 1 + depth.get(parents.key) : 0);
            parent.put(node.key, parents);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public static void main(String[] args) {
        Cousins c=new Cousins();
        TreeNode1 root=new TreeNode1(6);
        root.left=new TreeNode1(3);
        root.right=new TreeNode1(5);
        root.left.left=new TreeNode1(7);
        root.left.right=new TreeNode1(8);
        root.right.left=new TreeNode1(1);
        root.right.right=new TreeNode1(2);
        System.out.println(c.isCousins(root,7,5));
    }
}
class TreeNode1 {
    int key;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int key) { this.key = key; }
    TreeNode1(int key, TreeNode1 left, TreeNode1 right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}
