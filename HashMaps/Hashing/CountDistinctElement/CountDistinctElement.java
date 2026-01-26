import java.util.*;

public class CountDistinctElement {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 30, 40, 20, 50};
        int len = arr.length;

        Solution obj = new Solution();
        int distinctCount = obj.distinct(arr, len);
        System.out.println("Number of distinct elements: " + distinctCount);
    }
}

class Solution {
 
    public static int distinct(int[] arr, int len)
    {
      HashSet<Integer> hashSet = new HashSet<>();
      for(int i=0; i<len; i++){
        hashSet.add(arr[i]);
      }

      return hashSet.size();
    }
}