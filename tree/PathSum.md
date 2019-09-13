## Question
```
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
```
## 代码：

method 1:
Bottom-up, each recursive compare result and return to the root(parent) node.

JAVA:
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){return false;}
        return path(root, sum);
    }
    
    private boolean path(TreeNode root, int sum){
        if(root.left == null && root.right == null){
            if(sum - root.val == 0){return true;}
            return false;
        }
        boolean a = false;
        boolean b = false;
        if(root.left != null){
            a = path(root.left, sum- root.val);
        }
        if(root.right != null){
            b = path(root.right, sum - root.val);
        }
        return (a||b);
    }
}
```

method 2:

Top-down, 


