// User function Template for C++

class Solution {
    
    
    bool canPlaceCows(vector<int>& stalls, int n, int k, int distance) {
    int cowsPlaced = 1;
    int lastPos = stalls[0];

    for (int i = 1; i < n; i++) {
        if (stalls[i] - lastPos >= distance) {
            cowsPlaced++;
            lastPos = stalls[i];
        }
    }

    return cowsPlaced >= k;
}
public:

    int solve(int n, int k, vector<int> &stalls) {
    
        // Write your code here
        sort(stalls.begin(), stalls.end());

    int start = 1;
    int end = stalls[n - 1] - stalls[0];
    int maxMinDistance = -1;

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (canPlaceCows(stalls, n, k, mid)) {
            maxMinDistance = mid;
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }

    return maxMinDistance;

        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
};
