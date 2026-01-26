package HashMaps;

import java.util.HashMap;

//Pair with the Given Sum in an Unsorted Array
public class PairWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, -8};
        int sum = 16;
        int n = arr.length;

        Solution_PairWithGivenSum sol = new Solution_PairWithGivenSum();
        boolean result = sol.hasArrayTwoCandidates(arr, n, sum);
        System.out.println(result);
    }
}


class Solution_PairWithGivenSum {
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