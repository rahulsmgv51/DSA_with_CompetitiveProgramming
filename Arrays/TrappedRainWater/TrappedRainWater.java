package Arrays.TrappedRainWater;

public class TrappedRainWater {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }; // {4,2,0,3,2,5}
        System.out.println(trap(arr));
    }

    public int trap1(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int leftMax = height[left]; // Current maximum height from left side.
        int rightMax = height[right]; // Current maximum height from right side.

        int totalWater = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]); // Gives remaining water that will be trapped from left
                totalWater += (leftMax - height[left]);
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]); // Gives remaining water that will be trapped from right
                totalWater += (rightMax - height[right]);
            }
        }

        return totalWater;
    }

    public static long trap(int[] height) {
        int len = height.length;
        int leftH[] = new int[len];
        int rigtH[] = new int[len];
        int minL = Integer.MIN_VALUE;
        int minR = Integer.MIN_VALUE;
        long sum = 0;

        // Left side maximum height
        for (int i = 0; i < len; i++) {
            if (height[i] > minL) {
                minL = height[i];
            }
            leftH[i] = minL;
        }

        for (int i = len - 1; i >= 0; i--) {
            if (height[i] > minR) {
                minR = height[i];
            }
            rigtH[i] = minR;
        }

        for (int i = 0; i < len; i++) {
            sum += Math.min(leftH[i], rigtH[i]) - height[i];
        }

        return sum;

    }
}