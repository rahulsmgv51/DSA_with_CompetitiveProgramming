package Stack.PreviousLargerLeftElement;

import java.util.ArrayList;
import java.util.Stack;

public class PreviousLargerLeftElement {
    public static void main(String[] args) {
        int arr[] = {1, 6, 4, 10, 2, 5};
        System.out.println(previousSmallerElementIdx(arr));
    }

    private static ArrayList<Integer> previousSmallerElementIdx(int[] arr){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                stack.pop();
            }
            
            if(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                res.add(stack.peek());
            }else{
                res.add(-1);
            }

            stack.push(i);
        }

        return res;
    }
}