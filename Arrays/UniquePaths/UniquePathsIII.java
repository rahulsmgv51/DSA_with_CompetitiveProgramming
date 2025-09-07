package Arrays.UniquePaths;

public class UniquePathsIII {
    public static void main(String args[]) {
        int arr[][] = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
        System.out.println(uniquePathsIII(arr));
    }

    public static int uniquePathsIII(int[][] grid) {
        int nocount = 0;
        int gridi = 0;
        int gridj = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    nocount++;
                if (grid[i][j] == 1) {
                    nocount++;
                    gridi = i;
                    gridj = j;
                }
            }
        }
        int result[] = new int[1];
        System.out.println(" NonObstacle Count : " + nocount + ", i : " + gridi + ", j : " + gridj);
        backT(grid, gridi, gridj, 0, nocount, result);
        return result[0];
    }

    static int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void backT(int[][] arr, int x, int y, int count, int nocount, int[] result) {

        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length || arr[x][y] == -1) {
            return;
        }

        if (arr[x][y] == 2) {
            if (count == nocount)
                result[0]++;
            return;
        }
        arr[x][y] = -1;
        for (int[] rele : directions) {
            int newX = x + rele[0];
            int newY = y + rele[1];
            backT(arr, newX, newY, count + 1, nocount, result);
        }
        arr[x][y] = 0;
    }
}