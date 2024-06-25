/*You are given an array nums of positive integers and a positive integer k.
A subset of nums is beautiful if it does not contain two integers with an absolute difference equal to k.
Return the number of non-empty beautiful subsets of the array nums.
A subset of nums is an array that can be obtained by deleting some (possibly none) elements from nums. Two subsets are different if
 and only if the chosen indices to delete are different.

Example 1:
Input: nums = [2,4,6], k = 2
Output: 4
Explanation: The beautiful subsets of the array nums are: [2], [4], [6], [2, 6].
It can be proved that there are only 4 beautiful subsets in the array [2,4,6].*/

import java.util.*;
class Solution 
{
    public int beautifulSubsets(int[] nums, int k) 
    {
        int n = nums.length;
        int count = 0;
        
        for (int mask = 1; mask < (1 << n); mask++) 
        {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) 
            {
                if ((mask & (1 << i)) != 0) 
                {
                    subset.add(nums[i]);
                }
            }
            
            if (isBeautiful(subset, k)) 
            {
                count++;
            }
        }
        
        return count;
    }

    private boolean isBeautiful(List<Integer> subset, int k)
     
    {
        Set<Integer> seen = new HashSet<>();
        for (int num : subset) {
            if (seen.contains(num - k) || seen.contains(num + k)) 
            {
                return false;
            }
            seen.add(num);
        }
        return true;
    }
}