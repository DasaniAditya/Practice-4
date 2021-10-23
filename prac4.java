/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        result = 0;
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root,int sum) {
        //base
        if(root == null) {
            return;
        }
        //logic
        sum = sum * 10 + root.val;
        dfs(root.left, sum);
        if(root.left == null && root.right == null) {
            result += sum;
        }
        dfs(root.right, sum);
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1 ; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        
        for(int i = 1 ; i < grid.length; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        
        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j]);
            }
        }
        
        //System.out.println(Arrays.deepToString(dp));
        
        return dp[grid.length-1][grid[0].length-1];
        
    }
}