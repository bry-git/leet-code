import java.util.Arrays;

public class Solution {

    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        for (int i = 0; i <= nums.length -1; i++) {

            if(nums[i] == 0) throw new RuntimeException("cannot multiply by zero");

            int curr = nums[i];
            nums[i] = 1;
            int productExceptSelf = 1;
            for(int j : nums) {
                productExceptSelf*=j;
            }
            result[i] = productExceptSelf;
            nums[i] = curr;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3}))); // [6, 3, 2]
        System.out.println(Arrays.toString(productExceptSelf(new int[] {-1, 1, -1, 1, -1})));
    }
}
