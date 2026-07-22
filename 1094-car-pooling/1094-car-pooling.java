class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        // Maximum location is 1000 according to constraints
        int[] diff = new int[1001];

        // Mark passenger pickup and drop
        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            diff[from] += passengers; // Pick up passengers
            diff[to] -= passengers;   // Drop off passengers
        }

        int currentPassengers = 0;

        // Calculate prefix sum
        for (int i = 0; i <= 1000; i++) {
            currentPassengers += diff[i];

            if (currentPassengers > capacity) {
                return false;
            }
        }

        return true;
    }
}