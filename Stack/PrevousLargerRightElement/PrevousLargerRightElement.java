package Stack.PrevousLargerRightElement;

import java.util.Stack;

public class PrevousLargerRightElement {
    public static void main(String[] args) {
        int arr[] = {1, 6, 4, 10, 2, 4};
        int res[] = prevousSmallerRightElementIdx(arr);

        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }

    public static int[] prevousSmallerRightElementIdx(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }

            if(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                res[i] = stack.peek();
            }else{
                res[i] = n;
            }

            stack.push(i);
        }

        return res;
    }
}