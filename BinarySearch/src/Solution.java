public class Solution {
    /**
     * @param nums sorted collecton to search
     * @param target value within collection find
     * @return index of integer array where the value was found
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            }
        }
        return -1;
    }

    /**
     * @param nums sorted integer array to search
     * @param target value within integer array to find
     * @param left left side pointer to start with. outer method call should be 0 for left to right search
     * @param right right side pointer, should be nums.length -1 for left to right
     * @return the index of integer array where the value was found
     */
    public static int recursiveBinarySearch(int[] nums, int target, int left, int right) {

        if(nums.length == 0 || target < 0 || left > right) return -1; //base case validations

        int mid = (left + right) / 2;

        if(target == nums[mid]) return mid; //base case

        if(target > nums[mid]) { //target is higher than anything in left side
            return recursiveBinarySearch(nums, target, mid + 1, right);
        } else if(target < nums[mid]) { //target is lower than anything in right side
            return recursiveBinarySearch(nums, target, left, mid -1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 4, 5, 7, 8, 10}, 8));
        System.out.println(binarySearch(new int[]{1, 3, 4, 5, 7, 8, 11, 12, 14, 15, 16, 17}, 4));
        int[] nums = new int[]{1, 3, 4, 5, 7, 8, 11, 12, 14, 15, 16, 17};
        System.out.println(recursiveBinarySearch(nums, 4, 0, nums.length -1));
    }
}
