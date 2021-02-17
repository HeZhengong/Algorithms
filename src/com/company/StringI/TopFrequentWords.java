package com.company.StringI;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopFrequentWords {
    public String[] topKFrequent(String[] combo, int k) {
        if(combo==null){
            return new String[0];
        }
        Map<String,Integer> freqMap=getFreq(combo);
        PriorityQueue<Map.Entry<String,Integer>> minHeap=new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String,Integer>entry:freqMap.entrySet()) {
            if(minHeap.size()<k){
                minHeap.offer(entry);
            }
            else if(minHeap.peek().getValue()<entry.getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        return getHeap(minHeap);
    }

    private String[] getHeap(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
        String[] result=new String[minHeap.size()];
        for(int i=minHeap.size()-1;i>=0;i--){
            result[i]=minHeap.poll().getKey();
        }
        return result;
    }

    private Map<String, Integer> getFreq(String[] combo) {
        Map<String, Integer> freq=new HashMap<>();
        for (String s:combo) {
            Integer frequency=freq.get(s);
            if(frequency==null){
                freq.put(s,1);
            }
            else{
                freq.put(s,frequency+1);
            }
        }
        return freq;
    }


    public static void main(String[] args) {
        TopFrequentWords s=new TopFrequentWords();
        String[] test={"a","a","b","c","d","d","d","e","b","c","c"};
        String[] result=s.topKFrequent(test,4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
