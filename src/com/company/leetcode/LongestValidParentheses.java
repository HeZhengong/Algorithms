package com.company.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LongestValidParentheses {
    public class Solution {
        public int longestValidParentheses(String s) {
            int maxAns = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            stack.offerFirst(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.offerFirst(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.offerFirst(i);
                    } else {
                        maxAns = Math.max(maxAns, i - stack.peek());
                    }
                }
            }
            return maxAns;
        }
    }

}
