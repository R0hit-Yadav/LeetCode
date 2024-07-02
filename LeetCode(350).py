'''Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted'''

class Solution(object):
    def intersect(self, nums1, nums2):
        counts={}
        for num in nums1:
            if num in counts:
                counts[num]+=1
            else:
                counts[num]=1

        result=[]
        for num in nums2:
            if num in counts and counts[num]>0:
                result.append(num)
                counts[num]-=1
        return result
        