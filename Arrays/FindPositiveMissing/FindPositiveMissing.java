package Arrays.FindPositiveMissing;

public class FindPositiveMissing {
    public static void main(String[] args) {
        int arr[] = { 2, 1 }; // {1} {3,4,-1,-2,1,5,16,0,2,0} {3,4,-1,1} {7,8,9,11,12}
        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums) {
        boolean containsOne = false;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) containsOne = true;
            if (nums[i] < 1 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        if (!containsOne)
            return 1;

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
