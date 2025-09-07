package Arrays.RotateArray;

public class RotateArray {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        rotate(arr, 3);
        for(int ele : arr){
            System.out.print(ele+" ");
        }
    }

    public static void rotate(int[] arr, int k) {
        k = k % arr.length;
        // reverse first n-k elements
        reverse(arr, 0, arr.length - k - 1);
        // reverse last k elements
        reverse(arr, arr.length - k, arr.length - 1);
        // reverse whole array
        reverse(arr, 0, arr.length - 1);
    }

    // function to reverse an array
    public static void reverse(int arr[], int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    /*
     * public static void rotate(int[] arr, int k) {
     * int n = arr.length;
     * k = k%n;
     * int fal = n-k;
     * int sal = k;
     * for(int i=0; i<(fal/2); i++){
     * int tmp = arr[fal-i-1];
     * arr[fal-i-1] = arr[i];
     * arr[i] = tmp;
     * }
     * 
     * for(int ele: arr){
     * System.out.print(ele+" ");
     * }
     * 
     * System.out.println();
     * 
     * for(int i=fal,j=0; i<n-(sal/2); i++, j++){
     * int tmp = arr[n-j-1];
     * arr[n-j-1] = arr[i];
     * arr[i] = tmp;
     * }
     * 
     * for(int ele: arr){
     * System.out.print(ele+" ");
     * }
     * System.out.println();
     * 
     * for(int i=0; i<n/2; i++){
     * int tmp = arr[n-i-1];
     * arr[n-i-1] = arr[i];
     * arr[i] = tmp;
     * }
     * for(int ele: arr){
     * System.out.print(ele+" ");
     * }
     * }
     */
}