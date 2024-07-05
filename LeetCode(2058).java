/*A critical point in a linked list is defined as either a local maxima or a local minima.
A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.
A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.
Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.
Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between any two distinct critical points. If there are fewer than two critical points, return [-1, -1].

Example 1:

Input: head = [3,1]
Output: [-1,-1]
Explanation: There are no critical points in [3,1].*/

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) 
    {
        int minDistance=Integer.MAX_VALUE;
        int firstMaIndex=-1;
        int prevMaIndex=-1;
        int index=1;
        ListNode prev=head;
        ListNode curr=head.next;

        while(curr.next!=null)
        {
            if(curr.val>prev.val && curr.val>curr.next.val ||
            curr.val < prev.val && curr.val < curr.next.val)
            {
                if(firstMaIndex==-1)
                firstMaIndex=index;
                if(prevMaIndex!=-1)
                    minDistance=Math.min(minDistance,index - prevMaIndex);
                prevMaIndex=index;
            }
            prev=curr;
            curr=curr.next;
            ++index;
        }

        if(minDistance == Integer.MAX_VALUE)
            return new int[] {-1,-1};
        return new int[] {minDistance,prevMaIndex - firstMaIndex};
    }
}