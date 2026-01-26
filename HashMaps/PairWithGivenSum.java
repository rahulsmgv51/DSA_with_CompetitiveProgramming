package HashMaps;

import java.util.HashMap;

//Pair with the Given Sum in an Unsorted Array
//Two Sum Problem
public class PairWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, -8};
        int sum = 16;
        int n = arr.length;

        Solution_PairWithGivenSum sol = new Solution_PairWithGivenSum();
        boolean result = sol.hasArrayTwoCandidates(arr, n, sum);
        System.out.println(result);

        int resultIndices[] = sol.twoSum(arr, sum);
        if(resultIndices.length == 2){
            System.out.println("Indices: " + resultIndices[0] + ", " + resultIndices[1]+" Values: " + arr[resultIndices[0]] + ", " + arr[resultIndices[1]]);
        } else {
            System.out.println("No two sum solution found.");
        }
    }
}


class Solution_PairWithGivenSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
       
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.putIfAbsent(nums[i], i);
        }
        return new int[0];
    }
    
    public boolean hasArrayTwoCandidates(int arr[], int n, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            int complement = targetSum - num;
            if(map.containsKey(complement)){
                return true;
            }
            map.put(num, complement);
        }
        return false;
    }
}