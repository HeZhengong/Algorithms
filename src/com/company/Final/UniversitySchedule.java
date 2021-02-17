package com.company.Final;

import java.util.ArrayList;
import java.util.List;

public class UniversitySchedule {
    public List<String> findSchedule(String input){
        StringBuilder sb=new StringBuilder();
        List<String> result=new ArrayList<>();
        sb.append(input.charAt(0));
        helper(sb,input, result,1);
        return result;
    }

    private void helper(StringBuilder sb, String input, List<String> result, int index) {
        if(index==input.length()){
            result.add(sb.toString());
            return;
        }
        // Not add break//
        sb.append(input.charAt(index));
        helper(sb,input,result,index+1);
        sb.deleteCharAt(sb.length()-1);
        // add break//
        sb.append('x');
        sb.append(input.charAt(index));
        helper(sb,input,result,index+1);

        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
//        sb.deleteCharAt(sb.length()-2);

    }

    public static void main(String[] args) {
        UniversitySchedule s=new UniversitySchedule();
        System.out.print(s.findSchedule(new String("abc")));
    }
}
