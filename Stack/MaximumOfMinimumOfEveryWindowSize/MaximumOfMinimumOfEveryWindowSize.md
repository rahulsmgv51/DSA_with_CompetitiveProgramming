Maximum of Minimum for Every Window Size

Problem Statement
Given an integer array. The task is to find the maximum of the minimum of every window size in the array.
Note: Window size varies from 1 to the size of the Array.

Example 1:
Input:
N = 7
arr[] = [10,20,30,50,10,70,30]

Output: [70, 30, 20, 10, 10, 10, 10] 

Example 2:
Input:
N = 3
arr[] = [1, 2, 3]

Output: [3, 2, 1] 

Constraints:
1 <= N <= 105
1 <= arr[i] <= 106

Solution: 
1. find the nearest smaller element index in the left side. And if not present smaller then print -1;
2. find the nearest smaller element index in the right side. And in not present smaller then print size of array.
3. fill the minimum value in ans array of each element `Arrays.fill(ans, Integer.MIN_VALUE);`
4. find the window length index `wl = right[i]-left[i]-1; ans[wl-1] = Math.max(ans[wl-1], arr[i]);`
5. In the last fill all the element which value in MIN_VALUE `ans[i] = Math.max(ans[i], ans[i+1]);`