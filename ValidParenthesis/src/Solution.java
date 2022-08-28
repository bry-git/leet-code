import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

class Solution {

    /**
     * Details
     * Runtime: 2 ms, faster than 91.17% of Java online submissions for Valid Parentheses.
     * Memory Usage: 42.6 MB, less than 12.77% of Java online submissions for Valid Parentheses.
     */

    public static boolean isValid(String s) {
        if(s.length() % 2 != 0 || s.length() == 0) return false;

        Stack<Character> openings = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '{' || c == '[' || c == '(') {
                openings.push(c);
            } else if(c == '}' && !openings.isEmpty() && openings.peek() == '{') {
                openings.pop();
            } else if(c == ']' && !openings.isEmpty() && openings.peek() == '[') {
                openings.pop();
            } else if(c == ')' && !openings.isEmpty() && openings.peek() == '(') {
                openings.pop();
            } else return false;
        }
        return openings.isEmpty();
    }

    /**
     *
     * fails on cases like "([}}])"
     */

    public static boolean isAlmostValid(String s) {

        if (s.length() % 2 != 0 || s.length() == 0) {
            return false;
        }

        LinkedList<Character> chars = new LinkedList<>();
        for(int i = 0; i < s.length()-1; i++){
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '(') { //load all opening braces first
                chars.push(c);
                continue;
            }

            if(chars.isEmpty()) return false;

            String stack = Arrays.toString(chars.toArray());
            char check;

            switch (c) {
                case ')':
                    check = chars.pop();
                    if(check == '{' || check == '[') {
                        return false;
                    }
                    break;
                case '}':
                    check = chars.pop();
                    if(check == '(' || check == '[') {
                        return false;
                    }
                    break;
                case ']':
                    check = chars.pop();
                    if(check == '(' || check == '{') {
                        return false;
                    }
                    break;
            }
        }
        return (chars.isEmpty());
    }

    public static void main(String[] args) {
        System.out.println(isValid("{([])}"));
    }
}
