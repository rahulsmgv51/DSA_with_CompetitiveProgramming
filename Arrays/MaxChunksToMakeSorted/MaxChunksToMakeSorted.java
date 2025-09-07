package Arrays.MaxChunksToMakeSorted;

public class MaxChunksToMakeSorted {
    public static void main(String[] args){
        int arr[] = {2,0,3,1,7,6,4,5};//{4,3,2,1,0};//{1,0,2,3,4};
        System.out.println(maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
    	int count = 0;
        int n = arr.length;
        int idxNo = arr[0];
        for(int i=0; i<n; i++){
            idxNo = Math.max(idxNo, arr[i]);
            if(idxNo == i) count++;
        }

        return count;
    }
}