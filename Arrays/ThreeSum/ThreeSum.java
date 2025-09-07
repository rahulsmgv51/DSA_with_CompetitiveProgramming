package Arrays.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String args[]){
        int nums[] = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<nums.length-2; i++){
            int newTar = 0-nums[i];
            int li = i+1; int ri = nums.length-1; 
            if(i == 0 || (i> 0 && nums[i] != nums[i-1])){
                while(li < ri){
                    if(nums[li] + nums[ri] == newTar){
                        res.add(Arrays.asList(nums[i], nums[li], nums[ri]));
                        while(li < ri && nums[li] == nums[li+1]) li++;
                        while(li < ri && nums[ri] == nums[ri-1]) ri++;
                        li++;
                        ri--;
                    }
                    else if(nums[li] + nums[ri] > newTar) ri--;
                    else li++;
                }
            }
        }

        return res;
    }
}