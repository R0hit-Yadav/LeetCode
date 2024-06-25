'''Given an array of integers arr.
We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).

Let's define a and b as follows:
a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
Note that ^ denotes the bitwise-xor operation.
Return the number of triplets (i, j and k) Where a == b.


Example 1:

Input: arr = [2,3,1,6,7]
Output: 4
Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)'''

class Solution(object):
    def countTriplets(self, arr):
        n=len(arr)
        prefix =[0]*(n+1)
        for i in range(n):
            prefix[i+1]=prefix[i] ^ arr[i]
        res=0
        for i in range(n):
            for j in range(i+1,n):
                for k in range(j,n):
                    if prefix[j] ^ prefix[i] == prefix[k+1] ^ prefix[j]:
                        res+=1
        return res