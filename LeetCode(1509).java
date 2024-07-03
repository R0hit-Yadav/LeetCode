/*You are given an integer array nums.

In one move, you can choose one element of nums and change it to any value.

Return the minimum difference between the largest and smallest value of nums after performing at most three moves.
Example 1:

Input: nums = [5,3,2,4]
Output: 0
Explanation: We can make at most 3 moves.
In the first move, change 2 to 3. nums becomes [5,3,3,4].
In the second move, change 4 to 3. nums becomes [5,3,3,3].
In the third move, change 5 to 3. nums becomes [3,3,3,3].
After performing 3 moves, the difference between the minimum and maximum is 3 - 3 = 0.
Example 2:

Input: nums = [1,5,0,10,14]
Output: 1
Explanation: We can make at most 3 moves.
In the first move, change 5 to 0. nums becomes [1,0,0,10,14].
In the second move, change 10 to 0. nums becomes [1,0,0,0,14].
In the third move, change 14 to 1. nums becomes [1,0,0,0,1].
After performing 3 moves, the difference between the minimum and maximum is 1 - 0 = 1.
It can be shown that there is no way to make the difference 0 in 3 moves.*/
import java.util.*;
class Solution {
    public int minDifference(int[] nums) 
    {

        if(nums.length<=4)
        {
            return 0;
        }

        Arrays.sort(nums);

        int n=nums.length;
        int d1=nums[n-4]-nums[0];
        int d2=nums[n-3]-nums[1];
        int d3=nums[n-2]-nums[2];
        int d4=nums[n-1]-nums[3];

        return Math.min(Math.min(d1,d2),Math.min(d3,d4));   
    }
}