package Arrays.SpiralMatrix;
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args){
        // int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 1;
        int minR = 0;
        int minC = 0;
        int maxR = m-1;
        int maxC = n-1;

        while(count <= m*n){
            //top wall
            for(int i=minR, j=minC; j<=maxC && count<= m*n; j++){
                System.out.print(matrix[i][j]+" ");
                res.add(matrix[i][j]);
                count++;
            }
            minR++;
            //right wall
            for(int i=minR, j=maxC; i<=maxR && count<= m*n; i++){
                System.out.print(matrix[i][j]+" ");
                res.add(matrix[i][j]);
                count++;
            }
            maxC--;
            //bottem wall
            for(int i=maxR, j=maxC; j>=minC && count<= m*n; j--){
                System.out.print(matrix[i][j]+" ");
                res.add(matrix[i][j]);
                count++;
            }
            maxR--;
            //left wall
            for(int i=maxR, j=minC; i>=minR && count<= m*n; i--){
                System.out.print(matrix[i][j]+" ");
                res.add(matrix[i][j]);
                count++;
            }
            minC++;
        }
        System.out.println();
        return res;
    }
}
