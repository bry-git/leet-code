import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static String failingLongestCommonPrefix(String[] strs) {
        StringBuilder longestCommonPrefix = new StringBuilder();
        String start = strs[0];

        if(strs.length == 1 && Character.isAlphabetic(strs[0].charAt(0))) {
            longestCommonPrefix.append(strs[0]);
            return longestCommonPrefix.toString();
        } else if(strs[0] == null || strs[0].length() == 0) {
            return "";
        }

        //step through word
        for (int i = 1; i < strs.length; i++) {
            if(strs[0] == null || strs[i] == null) {
                return "";
            }

            //step through chars in word
            for(int j = 0; j <= strs[i].split("").length -1; j++){

                char c = strs[i].charAt(j);
                if(
                        Character.isAlphabetic(c)
                        && start.length() -1 >= j
                        && (start.charAt(j) == c)
                ) {
                    String duplicates = strs[i].substring(0, longestCommonPrefix.toString().length());
                    if(longestCommonPrefix.toString().equals(duplicates) && i >= 2) {
                        continue;
                    }
                    longestCommonPrefix.append(c);

                } else if(longestCommonPrefix.toString().contains(String.valueOf(c))) {
                    longestCommonPrefix.deleteCharAt(longestCommonPrefix.length() -1);
                }
            }
        }
        return longestCommonPrefix.toString();
    }


    /**
     * Details
     * Runtime: 1 ms, faster than 89.35% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 42 MB, less than 59.69% of Java online submissions for Longest Common Prefix.
     * */

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() -1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flight", "flew", "flow"}));
        System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[] {"a"}));
        System.out.println(longestCommonPrefix(new String[] {"!"}));
        System.out.println(longestCommonPrefix(new String[] {"",""}));
        System.out.println(longestCommonPrefix(new String[] {"cir","car"}));
        System.out.println(longestCommonPrefix(new String[] {"weewee","weed"}));

    }
}
