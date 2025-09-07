package Arrays.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args){
        int [][] arr =  { {6,8}, {1,3}, {2,4}, {9,10}, {5,7} };//{ {5,6}, {1,3}, {2,4} }; //{ {6,8}, {1,3}, {2,4}, {9,10}, {5,7} }; //{{1,4},{4,5}}; //{{1,3},{2,6},{8,10},{15,18}}; //{{1,3},{2,4},{6,8},{9,10}};
        int [][] res1 = new int[arr.length][arr[0].length];
        res1 = merge(arr);
        for(int[] row: res1){
            for(int ele : row){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<List<Integer>> reslist = new ArrayList<>();
        int lowerArr[] = new int[n];
        int upperArr[] = new int[n];
        
        for(int i=0; i<n; i++){
          lowerArr[i] = intervals[i][0];
          upperArr[i] = intervals[i][1];
        }
        Arrays.sort(lowerArr);
        Arrays.sort(upperArr);
        
        int i=0; int j=0; int k=0; int l = 1;
        while(l < n){
            if(lowerArr[l] > upperArr[j]){
                // List<Integer> tmplst = new ArrayList<>();
                // // res[k][0] = lowerArr[i];
                // tmplst.add(lowerArr[i]);
                // // res[k][1] = upperArr[j];
                // tmplst.add(upperArr[j]);
                // reslist.add(tmplst);

                reslist.add(Arrays.asList(lowerArr[i], upperArr[j]));
                i=j+1;
                // k++;
            }
            l++;
            j++;
        }
        // List<Integer> tmplst = new ArrayList<>();
        // tmplst.add(lowerArr[i]);
        // tmplst.add(upperArr[j]);
        // reslist.add(tmplst);
        reslist.add(Arrays.asList(lowerArr[i], upperArr[j]));

        int[][] res = new int[reslist.size()][2];
        for (int m = 0; m < reslist.size(); m++) {
            res[m][0] = reslist.get(m).get(0);
            res[m][1] = reslist.get(m).get(1);
        }

        return res;
    }
}
