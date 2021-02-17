package com.company.CrossTrainingII;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCopyDeepCopy {
    public RandomListNode copy(RandomListNode head) {
        if(head==null){
            return null;
        }
        Map<RandomListNode,RandomListNode> lookup=new HashMap<>();
        RandomListNode newHead=new RandomListNode(head.value);
        lookup.put(head,newHead);
        RandomListNode cur=newHead;
        while(head!=null){
            if(head.next!=null){
                if(!lookup.containsKey(head.next)){
                    lookup.put(head.next, new RandomListNode(head.next.value));
                }
                cur.next=lookup.get(head.next);
            }
            if(head.random!=null){
                if(!lookup.containsKey(head.random)){
                    lookup.put(head.random, new RandomListNode(head.random.value));
                }
                cur.random=lookup.get(head.random);
            }
            cur = cur.next;
            head = head.next;
        }
        return newHead;
    }
}

 class RandomListNode {
    public int value;
    public RandomListNode next;
    public RandomListNode random;
    public RandomListNode(int value) {
      this.value = value;
    }
}
