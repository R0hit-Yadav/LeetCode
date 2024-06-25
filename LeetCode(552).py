'''An attendance record for a student can be represented as a string where each character signifies whether the student was absent, late, or present on that day. 
The record only contains the following three characters:
'A': Absent.
'L': Late.
'P': Present.
Any student is eligible for an attendance award if they meet both of the following criteria:
The student was absent ('A') for strictly fewer than 2 days total.
The student was never late ('L') for 3 or more consecutive days.
Given an integer n, return the number of possible attendance records of length n that make a student eligible for an attendance award. 
The answer may be very large, so return it modulo 109 + 7.

Example 1:

Input: n = 2
Output: 8
Explanation: There are 8 records with length 2 that are eligible for an award:
"PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" is not eligible because there are 2 absences (there need to be fewer than 2).'''

class Solution(object):
    def checkRecord(self, n):
        if not n:
            return 0
        if n == 1:
            return 3
        dp = [1, 2, 4] + [0] * (n - 2)
        for i in range(3, n + 1):
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % (10 ** 9 + 7)
        res = dp[n] % (10 ** 9 + 7)
        for i in range(n):
            res += (dp[i] * dp[n - i - 1])  % (10 ** 9 + 7)
        return res % (10 ** 9 + 7)
        