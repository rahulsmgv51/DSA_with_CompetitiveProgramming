### 3Sum
* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105

### Solution
1. In this question one things is common, that is target value is always 0.
2. Now sort the array and iterate over them from 0th index and minus from target value to nums[i];
3. After subtracting we got a new target then over the new target we use two pointer algorithm to find the another two value as 2 Sum question.
4. Here some other posibility is that list of answer should not be duplicate then for this problem we make some validation over the iteration.
    1. nums[i] and nums[i-1] not be equal in the iteration by for loop.
    2. While iterating through while loop should also take care, the nums[li] and nums[li+1] not equal, if equal then move ahed. vica versa for the right index.