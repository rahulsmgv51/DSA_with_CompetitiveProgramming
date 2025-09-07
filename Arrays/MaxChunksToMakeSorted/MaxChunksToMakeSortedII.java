package Arrays.MaxChunksToMakeSorted;

public class MaxChunksToMakeSortedII {
    public static void main(String[] args) {
        int arr[] = {2,1,3,4,4};
        System.out.println(maxChunksToSortedII(arr));
    }

    public static int maxChunksToSortedII(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;
        int count = 0;
        int value = -1;
        int leftMax[] = new int[n];
        int rigthMin[] = new int[n];
        for(int i=0; i<n; i++){
            value = Math.max(arr[i], value);
            leftMax[i] = value;
        }
        value = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
            value = Math.min(arr[i], value);
            rigthMin[i] = value;
        }
        int i = 1;
        while(i < n){
            if(leftMax[i-1] <= rigthMin[i]){
                count++;
            }
            i++;
        }
       
        return count+1;
    }
}
