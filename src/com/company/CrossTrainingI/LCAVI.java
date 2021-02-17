package com.company.CrossTrainingI;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCAVI {
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
        Set<KnaryTreeNode> set = new HashSet<>(nodes);
        return helper(root, set);
    }

    public KnaryTreeNode helper(KnaryTreeNode root, Set<KnaryTreeNode> set){
        if(root==null){
            return null;
        }
        if(set.contains(root)){
            return root;
        }
        KnaryTreeNode found=null;
        for (KnaryTreeNode child:root.children) {
            KnaryTreeNode node=helper(child,set);
            if(node==null){
                continue;
            }
            if(found==null){
                found=node;
            }
            else{
                return root;
            }
        }
        return found;
    }
}
