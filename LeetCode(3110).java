/*You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.
Return the score of s.

Example 1:
Input: s = "hello"
Output: 13
Explanation:
The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111. So, the score of s 
would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.*/

class Solution 
{
    public int scoreOfString(String s) 
    {
        int[] array = new int[s.length()];
        int ans = 0, index = 0;
        for (char ch : s.toCharArray()) 
        {
            array[index++] = (int) ch;
        }
        for (int i = 1; i < s.length(); i++) 
        {
            ans += Math.abs(array[i - 1] - array[i]);
        }
        return ans;
        
    }
}