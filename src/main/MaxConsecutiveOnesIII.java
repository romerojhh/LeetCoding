package main;

/* 1004. Max Consecutive Ones III
 Given a binary array nums and an integer k, return
 the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 */
public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        MaxConsecutiveOnesIII m = new MaxConsecutiveOnesIII();
        System.out.println(m.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(m.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }

    public int longestOnes(int[] nums, int k) {
        // the longest contiguous 1's with k 0's
        if (nums.length == 0 || k < 0) {
            return 0;
        }
        int maxLength = 0;
        int left = 0;
        int counter = 0;
        int right;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                counter++;
            }
            while (counter > k) {
                maxLength = Math.max(maxLength, right - left);
                if (nums[left] == 0) {
                    counter--;
                }
                left++;
            }
        }

        return Math.max(maxLength, right - left);
    }
}
