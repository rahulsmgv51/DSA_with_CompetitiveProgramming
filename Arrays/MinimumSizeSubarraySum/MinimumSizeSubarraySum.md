### Minimum Size Subarray Sum

* Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104


### Solution
* A simple two pointer solution with sliding window.
* Using two pointers to keep track of the contiguos array - making it a sliding windon kinda algorithm.
1. Declare two pointer indexes l = 0, r = 0.
2. Incrementing r++ and accumulating the contiguos array sum.
3. If sum >= target update len which is tracking the min value Math.min(len, r - l)



- 
1. Create three integer variables left, right and sumOfCurrentWindow. The variables left and right form a subarray by pointing to the starting and ending indices of the current subarray (or window), and sumOfCurrentWindow stores the sum of this window. Initialize all of them with 0.
2. Create another variable res to store the answer to the problem. We initialize it to a large integer value.
3. We iterate over nums using right starting from right = 0 till nums.length - 1 incrementing right by 1 after each iteration. We perform the following inside this iteration:
    . Add element at index right to the current window, incrementing sumOfCurrentWindow by nums[right].
    . We check if sumOfCurrentWindow >= target. If so, we have a subarray that satisfies our condition. As a result, we attempt to update our answer variable with the length of this subarray. We perform res = min(res, right - left + 1). We then remove the first element from this window by reducing sumOfCurrentWindow by nums[left] and incrementing left by 1. This step is repeated in an inner loop as long as sumOfCurrentWindow >= target.
    . The current window's sum is now smaller than target. We need to add more elements to it. As a result, right is incremented by 1.
4. Return res.