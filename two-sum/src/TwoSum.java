import java.util.Arrays;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 *
 * <code>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * </code>
 */


/** https://www.code-recipe.com/post/two-sum
 * public class Solution {
 *     public int[] twoSum(int[] numbers, int target) {
 *         HashMap<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
 *         for(int i = 0; i < numbers.length; i++){
 *             Integer requiredNum = (Integer)(target - numbers[i]);
 *             if(indexMap.containsKey(requiredNum)){
 *                 int toReturn[] = {indexMap.get(requiredNum), i};
 *                 return toReturn;
 *             }
 *
 *             indexMap.put(numbers[i], i);
 *         }
 *         return null;
 *     }
 * }
 * */

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    System.out.println("I is :"+i);
                    System.out.println("J is :"+j);
                    return new int[]{i, j};
                }
                System.out.println("i: " + i + " j: " + j);
            }
        }
       return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {6, 3, 2, 7, 8, 4, 5, 9, 1};
        int[] numsb = {3, 2, 4};

        System.out.println(twoSum(numsb, 6));


        System.out.println(Arrays.toString(twoSum(nums, 8)));
        System.out.println(Arrays.toString(twoSum(nums, 6)));
        System.out.println(Arrays.toString(twoSum(nums, 3)));
    }
}


