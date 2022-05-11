package seqlist.leetcode;

import java.util.Stack;

public class Code20 {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            //将字符串转换为单个字符
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if (c == ')' && top != '(') {
                        return false;
                    }
                    if (c == ']' && top != '[') {
                        return false;
                    }
                    if (c == '}' && top != '{') {
                        return false;
                    }
                }
            }
            //如果栈不为空，左括号大于右括号
            return stack.isEmpty();
        }
    }
}
