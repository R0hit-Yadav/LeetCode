import java.util.ArrayList;
import java.util.List;
class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution 
{
    public TreeNode balanceBST(TreeNode root) 
    {
        List<Integer> sortedValues = new ArrayList<>();
        inOrderTraversal(root, sortedValues);
        return buildBalancedBST(sortedValues, 0, sortedValues.size() - 1);
    }

    private void inOrderTraversal(TreeNode node, List<Integer> sortedValues) 
    {
        if (node == null) 
        {
            return;
        }
        inOrderTraversal(node.left, sortedValues);
        sortedValues.add(node.val);
        inOrderTraversal(node.right, sortedValues);
    }

    private TreeNode buildBalancedBST(List<Integer> sortedValues, int start, int end) 
    {
        if (start > end) 
        {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(sortedValues.get(mid));
        node.left = buildBalancedBST(sortedValues, start, mid - 1);
        node.right = buildBalancedBST(sortedValues, mid + 1, end);
        return node;
    }
}
