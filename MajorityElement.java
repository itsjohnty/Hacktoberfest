class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Create a frequency map to store the count of each element
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        
        // Iterate through the input array to count element occurrences
        for (int i = 0; i < nums.length; i++) {
            elementCountMap.put(nums[i], elementCountMap.getOrDefault(nums[i], 0) + 1);
        }
        
        List<Integer> majorityElements = new ArrayList<>();
        int threshold = nums.length / 3;
        
        // Iterate through the frequency map to identify majority elements
        for (Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();
            
            // Check if the element count is greater than the threshold
            if (count > threshold) {
                majorityElements.add(element);
            }
        }
        
        return majorityElements;
    }
}
