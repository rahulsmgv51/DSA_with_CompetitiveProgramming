package Arrays.MinMaxGame;

public class MinMaxGame {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 2, 4, 8, 2, 2 };
        System.out.println(minMaxGame(arr));
    }

    public static int minMaxGame(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] newNums = new int[nums.length / 2];
        while (newNums.length > 1) {
            for (int i = 0; i < newNums.length; i += 2) {
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            }
            for (int i = 1; i < newNums.length; i += 2) {
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
            nums = newNums;
            newNums = new int[newNums.length / 2];
        }

        return Math.min(nums[0], nums[1]);
    }
}