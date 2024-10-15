'''You are given a 0-indexed integer array nums and an integer k. You have a starting score of 0.

In one operation:

choose an index i such that 0 <= i < nums.length,
increase your score by nums[i], and
replace nums[i] with ceil(nums[i] / 3).
Return the maximum possible score you can attain after applying exactly k operations.

The ceiling function ceil(val) is the least integer greater than or equal to val.


Example 1:
Input: nums = [10,10,10,10,10], k = 5
Output: 50
Explanation: Apply the operation to each array element exactly once. The final score is 10 + 10 + 10 + 10 + 10 = 50.'''\

import heapq
class Solution(object):
    def maxKelements(self, nums, k):
        res = 0
        mx_heap = [-num for num in nums]
        heapq.heapify(mx_heap)
       
        while k > 0:
            k -= 1
            t = -heapq.heappop(mx_heap)
            res += t
            heapq.heappush(mx_heap, -((t + 2) // 3))
        return res
