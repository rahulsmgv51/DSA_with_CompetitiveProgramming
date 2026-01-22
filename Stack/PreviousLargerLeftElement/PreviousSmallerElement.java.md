# Previous Smaller Element
- Given an array of integers, find the nearrest smaller number for every element such that the smaller element is on the left side.

- Input: arr[] = {1, 6, 4, 10, 2, 5}
- Output: arr[] = {-1, 0, 0, 2, 0, 4} -> Store array index


import java.util.ArrayList;
import java.util.Stack;

public class Solution{
    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A)
    {
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList <> ();
        Stack<Integer> s = new Stack <> ();
        for (int i = 0; i < n; i++)
        {
            while (!s.empty() && A.get(s.peek()) >= A.get(i))
            {
                s.pop();
            }
            if (!s.empty())
            {
                ans.add(A.get(s.peek()));
            }
            else
            {
                ans.add(-1);
            }
            s.push(i);
        }
        return ans;
    }
}
