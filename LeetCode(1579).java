/*Alice and Bob have an undirected graph of n nodes and three types of edges:
Type 1: Can be traversed by Alice only.
Type 2: Can be traversed by Bob only.
Type 3: Can be traversed by both Alice and Bob.
Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes ui and vi, 
find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both 
Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.

Return the maximum number of edges you can remove, or return -1 if Alice and Bob cannot fully traverse the graph.

Example 1:
Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
Output: 2
Explanation: If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will still be fully traversable by Alice and Bob. 
Removing any additional edge will not make it so. 
So the maximum number of edges we can remove is 2.

Example 2:
Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
Output: 0
Explanation: Notice that removing any edge will not make the graph fully traversable by Alice and Bob.


Example 3:
Input: n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
Output: -1
Explanation: In the current graph, Alice cannot reach node 4 from the other nodes. Likewise, Bob cannot reach 1. 
Therefore it's impossible to make the graph fully traversable.*/

import java.util.*;
class UnionFind 
{
  public UnionFind(int n) 
  {
    count = n;
    id = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; ++i)
      id[i] = i;
  }

  public boolean unionByRank(int u, int v) 
  {
    final int i = find(u);
    final int j = find(v);
    if (i == j)
      return false;
    if (rank[i] < rank[j]) 
    {
      id[i] = j;
    } 
    else if (rank[i] > rank[j]) 
    {
      id[j] = i;
    } 
    else 
    {
      id[i] = j;
      ++rank[j];
    }
    --count;
    return true;
  }

  public int getCount() 
  {
    return count;
  }

  private int count;
  private int[] id;
  private int[] rank;

  private int find(int u) 
  {
    return id[u] == u ? u : (id[u] = find(id[u]));
  }
}

class Solution 
{
  public int maxNumEdgesToRemove(int n, int[][] edges) 
  {
    UnionFind alice = new UnionFind(n);
    UnionFind bob = new UnionFind(n);
    int requiredEdges = 0;

    // Greedily put type 3 edges in the front.
    Arrays.sort(edges, (a, b) -> b[0] - a[0]);

    for (int[] edge : edges) 
    {
      final int type = edge[0];
      final int u = edge[1] - 1;
      final int v = edge[2] - 1;
      switch (type) 
      {
        case 3: // Can be traversed by Alice and Bob.
          // Note that we should use | instead of || because if the first
          // expression is true, short-circuiting will skip the second
          // expression.
          if (alice.unionByRank(u, v) | bob.unionByRank(u, v))
            ++requiredEdges;
          break;
        case 2: // Can be traversed by Bob.
          if (bob.unionByRank(u, v))
            ++requiredEdges;
        case 1: // Can be traversed by Alice.
          if (alice.unionByRank(u, v))
            ++requiredEdges;
      }
    }

    return alice.getCount() == 1 && bob.getCount() == 1 ? edges.length - requiredEdges : -1;
  }
}