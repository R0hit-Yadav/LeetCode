/*Given a string s, partition s such that every substring of the partition is a 
palindrome Return all possible palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]*/

import java.util.*;
class Solution 
{
    public List<List<String>> partition(String s) 
    {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(String s, int start, List<String> currentList, List<List<String>> result) 
    {
        if (start == s.length()) 
        {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int end = start; end < s.length(); end++) 
        {
            if (isPalindrome(s, start, end)) 
            {
                currentList.add(s.substring(start, end + 1));
                backtrack(s, end + 1, currentList, result);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int low, int high) 
    {
        while (low < high) 
        {
            if (s.charAt(low++) != s.charAt(high--)) 
            {
                return false;
            }
        }
        return true;
    }

}