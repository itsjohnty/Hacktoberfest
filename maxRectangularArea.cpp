// PROBLEM - Maximum Rectangular Area in a Binary Matrix

// Time Complexity - O(n*m) where n is rows and m is columns 
// Space Complexity - O(m) where m is columns 

#include <bits/stdc++.h>
using namespace std;
#define MAX 100

class Solution{
  private:
  
    vector<int> nextSmallerElement(int *arr, int n) {
        stack<int> s;
        s.push(-1);
        vector<int> ans(n);

        for(int i = n-1; i >= 0 ; i--) {
            int curr = arr[i];

            while(s.top() != -1 && arr[s.top()] >= curr)
            {
                s.pop();
            }

            ans[i] = s.top();
            s.push(i);
        }
        return ans;
    }
    
    vector<int> prevSmallerElement(int* arr, int n) {
        stack<int> s;
        s.push(-1);
        vector<int> ans(n);

        for(int i = 0; i < n; i++) {
            int curr = arr[i];

            while(s.top() != -1 && arr[s.top()] >= curr)
            {
                s.pop();
            }

            ans[i] = s.top();
            s.push(i);
        }
        return ans; 
    }    
    
    int largestRectangleArea(int* heights, int n) {
        
        vector<int> next(n);
        next = nextSmallerElement(heights, n);
            
        vector<int> prev(n);
        prev = prevSmallerElement(heights, n);
        
        int area = INT_MIN;
        for(int i=0; i<n; i++) {
            int l = heights[i];
            
            if(next[i] == -1) {
                next[i] = n;
            }
             int b = next[i] - prev[i] - 1;
            int newArea = l*b;
            area = max(area, newArea);
        }
        return area;
    }

  public:
    int maxArea(int M[MAX][MAX], int rows, int cols) {
        
        int area = largestRectangleArea(M[0], cols); //compute area for first row
        
        for(int i = 1; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                
                //row udpate: by adding previous row's value
                if(M[i][j] != 0)
                    M[i][j] = M[i][j] + M[i-1][j];
                else
                    M[i][j] = 0; // When, current value is zero, at it as 0 (base hi zero hai toh upar ki nahi leni hai)
            }
            //entire row is updated now
            
            // take maximum area for all base rows
            area = max(area, largestRectangleArea(M[i], cols));
            
        }
        return area;
    }
};


int main() {
    int T;
    cin >> T;

    int M[MAX][MAX];

    while (T--) {
        int n, m;
        cin >> n >> m;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> M[i][j];
            }
        }
        
        Solution obj;
        cout << obj.maxArea(M, n, m) << endl;
    }
}