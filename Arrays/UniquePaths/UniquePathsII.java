package Arrays.UniquePaths;

public class UniquePathsII {
    public static void main(String args[]) {
        // int arr[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        int arr[][] = {{0,1},{0,0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int gridi = 0;
        int gridj = 0;

        int result[] = new int[1];
        // System.out.println(" i : " + gridi + ", j : " + gridj);
        backT(obstacleGrid, gridi, gridj, result);
        return result[0];
    }

    static int directions[][] = { { 1, 0 }, { 0, 1 } };

    public static void backT(int[][] arr, int x, int y, int[] result) {

        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length || arr[x][y] == 1) {
            return;
        }

        if (x == arr.length-1 && y == arr[0].length-1) {
            result[0]++;
            return;
        }

        arr[x][y] = 1;
        for (int[] rele : directions) {
            int newX = x + rele[0];
            int newY = y + rele[1];
            backT(arr, newX, newY, result);
        }
        arr[x][y] = 0;
    }
}