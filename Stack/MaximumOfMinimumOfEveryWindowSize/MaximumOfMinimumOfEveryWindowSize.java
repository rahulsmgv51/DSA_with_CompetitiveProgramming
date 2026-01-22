package Stack.MaximumOfMinimumOfEveryWindowSize;

import java.util.Stack;

class MaximumOfMinimumOfEveryWindowSize {
    public static void main(String[] args) {
        int[] arr = {10,20,30,50,10,70,30};
        int[] res = maxOfMin(arr, arr.length);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }

    public static int[] maxOfMin(int[] arr, int n){
        Stack<Integer> stack = new Stack<>();

        int left[] = new int[n];
        int rigth[] = new int[n];

        for(int i=0; i<n; i++){
            left[i] = -1;
            rigth[i] = n;
        }

        // Left Array nearrest smaller element index
        for(int i=0; i<n; i++){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        //Emptying the stack for using to the right[]
        while (!stack.isEmpty()) {
            stack.pop();
        }

        // Rigth Array nearrest smaller element index
        for(int i=n-1; i>=0; i--){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                rigth[i] = stack.peek();
            }
            stack.push(i);
        }

        int ans[] = new int[n+1];
        for(int i=0; i<n; i++){

            //window length
            int len = rigth[i]-left[i]-1;

            ans[len] = Math.max(ans[len], arr[i]);
        }

        for(int i=n-1; i>=1; i--){
            ans[i] = Math.max(ans[i], ans[i+1]);
        }

        int[] res = new int[n];
        for(int i=1; i<=n; i++){
            res[i-1] = ans[i];
        }

        return res;
    }
}