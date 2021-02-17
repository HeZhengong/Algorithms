package com.company;

import java.lang.reflect.AnnotatedWildcardType;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public String longestCommonPrefix(String[] strs){
        if(strs.length==0){
            return "";
        }
        String answer = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j=0;
            for(;j<answer.length()&&j<strs[i].length();j++){
                if(answer.charAt(j)!= strs[i].charAt(j))
                    break;
                //answer=answer.substring(0,j);
            }
            answer=answer.substring(0,j);
            if(answer==""){
                return answer;
            }
        }
        return answer;
    }

    public static Boolean isValid(String s){
        Stack<Character> stack= new Stack<>();
        char[] chars=s.toCharArray();
        for (char achar:chars) {
            if(stack.size()==0)
                stack.push(achar);
            else if(isSyn(achar, stack.peek())){
                stack.pop();
            }
            else{
                stack.push(achar);
            }
            
        }
        return stack.size()==0;

    }

    public static Boolean isSyn(char c1, char c2){
        return(c1=='(' && c2==')'||c1=='['&& c2==']'||c1=='{'&&c2=='}');

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode head=dummyHead;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                head.next=l1;
                head=head.next;
                l1=l1.next;
            }
            else{
                head.next=l2;
                head=head.next;
                l2=l2.next;
            }
        }

        if(l1==null){
            head.next=l2;
        }
        if(l2==null){
            head.next=l1;
        }
        return dummyHead.next;

    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }

    }



    public static void main(String[] args) {
//        String s="()";
//        isValid(s);
	// write your code here
    }
}
