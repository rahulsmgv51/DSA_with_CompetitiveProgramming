package Arrays.MaximumAbsoluteSumOfAnySubarray;

public class MaximumAbsoluteSumOfAnySubarray {
    public static void main(String[] args){
        int arr[] = {2,-5,1,-4,3,-2};
        System.out.println("Max Sum : "+ maxAbsoluteSum(arr));
    }

    public static int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int minSum = nums[0];
        int maxSum = nums[0];

        int currSubMax = nums[0];
        int currSubMin = nums[0];

        for(int i=1; i<n; i++){
            currSubMax = Math.max(nums[i], currSubMax+nums[i]);
            maxSum = Math.max(maxSum, currSubMax);

            currSubMin = Math.min(nums[i], currSubMin+nums[i]);
            minSum = Math.min(minSum, currSubMin);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}
