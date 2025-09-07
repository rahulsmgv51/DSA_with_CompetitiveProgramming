package Arrays.MinimumOperationsToMakeAllArrayElementsEqual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumOperationsToMakeAllArrayElementsEqual{
    public static void main(String[] args){
        int[] nums = {2,9,6,3};
        int[] queries = {10};
        // int[] nums = {3,1,6,8};
        // int[] queries = {5};
        System.out.println(minOperations(nums, queries));

       System.out.println("Program End");
    }

    public static List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);

        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        List<Long> result = new ArrayList<>();

        for (int q : queries) {
            int idx = Arrays.binarySearch(nums, q);

            if (idx < 0) {
                idx = -idx - 1;
            }

            long leftSum = prefixSum[idx];
            long leftOps = (long) q * idx - leftSum;

            long rightSum = prefixSum[n] - prefixSum[idx];
            long rightOps = rightSum - (long) q * (n - idx);

            result.add(leftOps + rightOps);
        }

        return result;
    }
}