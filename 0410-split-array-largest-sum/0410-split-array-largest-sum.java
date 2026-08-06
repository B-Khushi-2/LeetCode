class Solution {

    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        for (int i = 0; i < nums.length; i++) {

            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean canSplit(int[] nums, int k, int maxSum) {

        int parts = 1;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (currentSum + nums[i] <= maxSum) {

                currentSum += nums[i];

            } else {

                parts++;
                currentSum = nums[i];
            }
        }

        return parts <= k;
    }
}