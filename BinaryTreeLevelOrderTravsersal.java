// Time Complexity : O(n) - we visit each node once
// Space Complexity : O(n) - for the queue in the worst case
// Approach:
// We perform a level order traversal (Breadth First Search) using a queue.
// For each level, we take the number of nodes in the queue (size), process them, 
// and add their children back to the queue. 
// This way, we build a list of nodes at each level and finally return the result.


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeLevelOrderTravsersal {
    public List<List<Integer>> solve(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ans = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                ans.add(cur.val);
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }

            }
            res.add(ans);
        }

        return res;
    }
    public static void main(String[]args){

        TreeNode root = new TreeNode(3,
                        new TreeNode(9),
                        new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        
        BinaryTreeLevelOrderTravsersal ob = new BinaryTreeLevelOrderTravsersal();
        System.out.println(ob.solve(root));



    }
    
}
