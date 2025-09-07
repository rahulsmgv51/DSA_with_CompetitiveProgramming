package Arrays.SpiralMatrix;

public class SpiralMatrixII {
    public static void main(String[] args){
        int arr[][] = generateMatrix(5);
        for(int[] row: arr){
            for(int ele: row){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int count = 1;
        int arr[][] = new int[n][n];
        int minC = 0;
        int minR = 0;
        int maxC = n-1;
        int maxR = n-1;
        while(count <= n*n){
            // top wall
            for(int i=minR, j=minC; j<=maxC; j++){
                arr[i][j] = count++;
            }
            minR++;
            //right wall
            for(int i=minR, j=maxC; i<=maxR; i++){
                arr[i][j] = count++;
            }
            maxC--;
            //bottom wall
            for(int i=maxR, j=maxC; j>=minC; j--){
                arr[i][j] = count++;
            }
            maxR--;
            //left wall
            for(int i=maxR, j=minC; i>=minR; i--){
                arr[i][j] = count++;
            }
            minC++;
        }
        return arr;
    }
}