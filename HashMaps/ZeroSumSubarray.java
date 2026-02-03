package HashMaps;

import java.util.Map;
import java.util.HashMap;

/* Zero Sum Subarray
Given an array of positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.
Example:
Input: {4, 2, -3, 1, 6}   
Output: true
Explanation: The subarray {2, -3, 1} has sum 0 */
public class ZeroSumSubarray {
    public static void main(String[] args) {
        int[] arr = { 1, 4, -5, 2, 3, -3 };// {4, 2, -7, 1, 6};
        boolean result = findsum(arr, arr.length);
        System.out.println(result);
        System.out.println(Solution_findSum.findsum(arr, arr.length));
    }

    public static boolean findsum(int arr[], int n) {
        // int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                // result[j] = j;
                if (sum == 0) {
                    return true;
                }
            }
            // Arrays.fill(result, 0);
        }
        return false;
    }

}

// Optimized approach using prefix-sum frequencies
class Solution_findSum {
    public static boolean findsum(int arr[], int n) {
        Map<Integer, Integer> freq = new HashMap<>();
        int sum = 0;
        int count = 0;
        freq.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            int seen = freq.getOrDefault(sum, 0);
            if (seen > 0) {
                count += seen;
            }
            freq.put(sum, seen + 1);
        }

        System.out.println("Count of zero sum subarray : " + count);

        return (count > 0) ? true : false;
    }
}
