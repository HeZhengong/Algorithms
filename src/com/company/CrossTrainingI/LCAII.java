package com.company.CrossTrainingI;

 class TreeNodeP {
    public int key;
    public TreeNodeP left;
    public TreeNodeP right;
    public TreeNodeP parent;
    public TreeNodeP(int key, TreeNodeP parent) {
      this.key = key;
      this.parent = parent;
    }
 }
public class LCAII {
        public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
            int l1=findLength(one);
            int l2=findLength(two);
            if(l1<=l2){
                return mergeNode(one, two, l2-l1);
            }
            else{
                return mergeNode(two, one, l1-l2);
            }
        }

        private TreeNodeP mergeNode(TreeNodeP one, TreeNodeP two, int difference){
            while(difference>0){
                two = two.parent;
                difference--;
            }
            while(one.key!=two.key){
                one = one.parent;
                two = two.parent;
            }
            return one;
        }

        private int findLength(TreeNodeP target){
            int length=0;
            while(target!=null){
                target=target.parent;
                length++;
            }
            return length;
        }

    public static void main(String[] args) {
        LCAII s=new LCAII();
        TreeNodeP one=new TreeNodeP(2,new TreeNodeP(9,new TreeNodeP(5,null)));
        TreeNodeP two=new TreeNodeP(3,new TreeNodeP(9,new TreeNodeP(5,null)));
        TreeNodeP three =new TreeNodeP(14,new TreeNodeP(12,new TreeNodeP(5,null)));
        TreeNodeP result= s.lowestCommonAncestor(one, three);
        System.out.print(result.key);
    }
}
