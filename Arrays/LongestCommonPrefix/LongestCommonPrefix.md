### Longest Common Prefix
* Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.

### Solution
1. Check for Empty Input:
    - If the array strs is empty, return an empty string "".
2. Initialize a Pointer:
    - Set prefixLenght = 0 to track how many characters are common from the start (prefix length).
3. Start Infinite Loop:
    - Repeat until we break (when mismatch is found or end of any string is reached):
4. Check Bounds for First String:
    - If prefixLenght is greater than or equal to the length of the first string:
        - Break the loop (prefix can't be longer than the shortest string).
5. Fetch Character to Compare:
    - Get the character at position prefixLenght from the first string, call it ch.
6. Compare with Other Strings:
    - Initialize a boolean flag allwell = true.
    - Loop through the rest of the strings (from index 1 to end):
        - If prefixLenght is out of bounds for current string OR character at prefixLenght does not match ch:
            - Set allwell = false and break out of the loop.
7. Check Comparison Result:
    - If allwell is true:
        - Increment prefixLenght and repeat to check next character.
    - Else:
        - Break the loop (prefix mismatch found).

8. Return the Prefix:
    - Return the substring from index 0 to prefixLenght of the first string.