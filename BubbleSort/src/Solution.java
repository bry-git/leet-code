import java.util.Arrays;

public class Solution {
    public static int[] bubbleSort(int[] nums) throws InterruptedException {
        int i, j, temp = 0;

        for(i = 0; i < nums.length - 1; i++) {
            for(j = 0; j < nums.length - 1 - i; j++) {  // the expression 'j<nums.length-1-i' is here because once the inner loop completes once,
                if(nums[j] > nums[j +1]) {              // the rightmost element of nums is the greatest value in the array. so dont compare its already sorted
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Arrays.toString(bubbleSort(new int[]{5, 1, 2, 6, 9, 8})));
    }
}
