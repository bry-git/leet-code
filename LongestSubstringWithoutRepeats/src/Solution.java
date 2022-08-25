import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */

/**
 * Details
 * Runtime: 14 ms, faster than 49.05% of Java online submissions for Longest Substring Without Repeating Characters.
 * Memory Usage: 46.2 MB, less than 32.63% of Java online submissions for Longest Substring Without Repeating Characters.
 */

public class Solution {

    public static int lengthOfLongestSubstring(String s) {

        int i = 0;
        int j = 0;
        int max = 0;

        HashSet<Character> seq = new HashSet<>();

        while(j < s.length()) {
            if (!seq.contains(s.charAt(j))) {
                seq.add(s.charAt(j));
                j++;
                max = max > seq.size() ? max : seq.size();
            } else {
                seq.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
