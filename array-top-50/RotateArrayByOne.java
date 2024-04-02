class ArrayRotation {
    
    // Method to rotate the elements of an array to the right by one position
    public void rotateRight(int[] arr, int n) {
        // Store the first element of the array
        int lastElement = arr[0];
        
        // Iterate through the array and shift elements to the right by one position
        for(int i = 0; i < n; i++) {
            int temp = arr[i];
            arr[i] = lastElement;
            lastElement = temp;
        }
        
        // Move the stored first element to the last position
        arr[0] = lastElement;
    }
    
    // Time Complexity Analysis: O(N)
    // The time complexity of the rotateRight method is O(N), where N is the number of elements in the array, 
    // because we iterate through the entire array once.
    
    // Space Complexity Analysis: O(1)
    // The space complexity of the rotateRight method is O(1), because we only use a constant amount of extra space.
}
