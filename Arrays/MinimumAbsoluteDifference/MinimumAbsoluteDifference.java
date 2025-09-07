package Arrays.MinimumAbsoluteDifference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        int arr[] = {1,3,6,10,15};
        System.out.println(minimumAbsDifference(arr));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);

        List<List<Integer>> list = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for(int i=1; i<len; i++){
            minDiff = Math.min(minDiff, arr[i]-arr[i-1]);
        }

        for(int i=1; i<len; i++){
            if(arr[i]-arr[i-1] == minDiff){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[i-1]);
                tmp.add(arr[i]);
                list.add(tmp); 
            }
        }

        return list;
    }
}