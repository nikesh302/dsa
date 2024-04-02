/*The Node structure is defined as
struct Node {
    int data;
    Node *left;
    Node *right;

};
*/

//-------------- Approach 1 --------------//
import java.util.ArrayList;
import java.util.List;

class Solution {
    
    // Method to find the minimum absolute difference between any two nodes in a binary search tree
    public int minAbsoluteDifference(Node root) {
        List<Integer> inorderTraversal = new ArrayList<>();
        inorder(root, inorderTraversal);
        
        // Calculate minimum absolute difference
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < inorderTraversal.size(); i++) {
            int diff = Math.abs(inorderTraversal.get(i) - inorderTraversal.get(i - 1));
            minDiff = Math.min(minDiff, diff);
        }
        
        return minDiff;
    }
    
    // Helper method to perform inorder traversal of the binary search tree
    private void inorder(Node node, List<Integer> inorderTraversal) {
        if (node == null) {
            return;
        }
        
        // Traverse left subtree
        inorder(node.left, inorderTraversal);
        
        // Add current node's value to the inorder traversal list
        inorderTraversal.add(node.data);
        
        // Traverse right subtree
        inorder(node.right, inorderTraversal);
    }
    
    // Time Complexity Analysis: O(N)
    // The time complexity of the minAbsoluteDifference method is O(N), where N is the number of nodes in the tree, 
    // because we perform an inorder traversal of the entire tree.
    // The time complexity of the inorder helper method is also O(N), where N is the number of nodes in the tree, 
    // because we visit each node exactly once.
    
    // Space Complexity Analysis: O(N)
    // The space complexity of both methods is O(N), where N is the number of nodes in the tree, 
    // because we use an additional list to store the inorder traversal, which can contain up to N elements.
}


//-------------- Approach 2 --------------//
class Solution {
    
    // Method to find the minimum absolute difference between any two nodes in a binary search tree
    public int minAbsoluteDifference(Node root) {
        int[] current = {Integer.MAX_VALUE}; // Store the current node's value during traversal
        int[] minDiff = {Integer.MAX_VALUE}; // Store the minimum absolute difference
        
        inorderTraversal(root, current, minDiff); // Perform inorder traversal
        
        return minDiff[0]; // Return the minimum absolute difference
    }
    
    // Helper method to perform inorder traversal of the binary search tree
    private void inorderTraversal(Node node, int[] current, int[] minDiff) {
        if (node == null) {
            return;
        }
        
        // Traverse left subtree
        inorderTraversal(node.left, current, minDiff);
        
        // Calculate absolute difference between current node and previous node
        minDiff[0] = Math.min(minDiff[0], Math.abs(current[0] - node.data));
        
        // Update current node value
        current[0] = node.data;
        
        // Traverse right subtree
        inorderTraversal(node.right, current, minDiff);
    }
    
    // Time Complexity Analysis: O(N)
    // The time complexity of the minAbsoluteDifference method is O(N), where N is the number of nodes in the tree, 
    // because we perform an inorder traversal of the entire tree.
    // The time complexity of the inorderTraversal helper method is also O(N), where N is the number of nodes in the tree, 
    // because we visit each node exactly once.
    
    // Space Complexity Analysis: O(1)
    // The space complexity of both methods is O(1), because we only use a constant amount of extra space for the arrays.
}
