package Arrays.TwoSum;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int nums[] = {3,2,4};
        int res[] = twoSum(nums, 6);
        for(int ele: res){
            System.out.print(ele +" ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
       
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}