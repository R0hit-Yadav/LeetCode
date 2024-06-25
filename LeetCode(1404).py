'''Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:
If the current number is even, you have to divide it by 2.
If the current number is odd, you have to add 1 to it.
It is guaranteed that you can always reach one for all test cases.


Example 1:

Input: s = "1101"
Output: 6
Explanation: "1101" corressponds to number 13 in their decimal representation.
Step 1) 13 is odd, add 1 and obtain 14. 
Step 2) 14 is even, divide by 2 and obtain 7.
Step 3) 7 is odd, add 1 and obtain 8.
Step 4) 8 is even, divide by 2 and obtain 4.  
Step 5) 4 is even, divide by 2 and obtain 2. 
Step 6) 2 is even, divide by 2 and obtain 1. '''

class Solution(object):
    def numSteps(self, s):
        ans = 0
        s = list(s[::-1])  # Reverse the string and convert it to a list for mutable operations
        
        while len(s) > 1:  # Continue until the string length becomes 1
            ans += 1
            if s[0] == '1':  # If the current bit is '1'
                i = 0
                while i < len(s) and s[i] == '1':
                    s[i] = '0'
                    i += 1
                if i == len(s):
                    s.append('1')  # If all bits were '1', add a new '1' at the end
                else:
                    s[i] = '1'  # Change the first '0' to '1'
            else:  # If the current bit is '0'
                s.pop(0)  # Remove the current bit (divide by 2)
        
        return ans  # Return the total number of steps

# Example usage:
sol = Solution()
print(sol.numSteps("1101"))  # Output: 6
        
        