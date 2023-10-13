public class Water_jug {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        // Check if the total capacity of both jugs is less than the target capacity.
        if(jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        
        // Check if one of the jugs has the same capacity as the target, or if the sum of the jugs' capacities is the target.
        if (jug1Capacity == targetCapacity || jug2Capacity == targetCapacity || jug1Capacity + jug2Capacity == targetCapacity) {
            // If any of these conditions are met, return true.
            return true;
        }
        
        // Calculate the greatest common divisor (GCD) of the jug capacities.
        int a = gcd(jug1Capacity, jug2Capacity);
        
        // Check if the target capacity is divisible by the GCD.
        if (targetCapacity % a == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Helper function to calculate the greatest common divisor.
    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        Water_jug solution = new Water_jug();
        
        int jug1Capacity1 = 3, jug2Capacity1 = 5, targetCapacity1 = 4;
        boolean result1 = solution.canMeasureWater(jug1Capacity1, jug2Capacity1, targetCapacity1);
        System.out.println("Example 1: " + result1); // Output: true

    }
}
