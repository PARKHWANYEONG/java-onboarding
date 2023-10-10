package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        
        String result = removeDuplication(cryptogram);
    }
    private static String removeDuplication(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = cryptogram.toCharArray();
        char pre = '\u0000';
        for (char ch : charArray) {
            if (pre != ch) {
                stack.push(ch);
                pre = ch;
            } else {
                stack.pop();
            }
        }
        return stack.stream().map(ch -> String.valueOf(ch)).collect(Collectors.joining());
    }
}
