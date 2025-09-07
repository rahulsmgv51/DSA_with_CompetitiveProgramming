package Arrays.MinimumSizeSubarraySum;

public class MinimumSizeSubarraySum {
    public static void main(String[] args){
        int nums[] = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minSize = Integer.MAX_VALUE;
        int l=0; int r=0;
        int curTar=0;

        while(r < nums.length){
            curTar += nums[r];
            while(curTar >= target){
                minSize = Math.min(minSize, r-l+1);
                curTar -= nums[l];
                l++;
            }
            r++;
        }

        return (minSize == Integer.MAX_VALUE)? 0:minSize;
    }
}
