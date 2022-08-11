import java.util.Arrays;

/**
 * Details
 * Runtime: 27 ms, faster than 12.10% of Java online submissions for Palindrome Number.
 * Memory Usage: 42 MB, less than 87.96% of Java online submissions for Palindrome Number.
 * */

class Solution {
    public static boolean isPalindrome(int x) {
        String[] nums = String.valueOf(x).split("");
        String[] reversed = new String[nums.length];
        int j = 0;
        for(int i = nums.length; i > 0; i--) {
            reversed[j] = nums[i - 1];
            j++;
        }
        return Arrays.equals(reversed, nums);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121)); //true
        System.out.println(isPalindrome(123454321)); //true
        System.out.println(isPalindrome(1112221111)); // false
        System.out.println(isPalindrome(12345678)); // false

    }
}


