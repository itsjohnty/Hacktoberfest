

//User function Template for Java



class Solution
{
    // Complete the function
    // n: Input n
    public static boolean isLucky(int n)
    {
        // Your code here
  if (n % 2 == 0) {
            return false;
        }
        int x = 2;

        while (n >= x) {
            if (n % x == 0) {
                return false;
            }
            n -= n / x;
            x++;
        }

        return true;
        
        
        
        
    }
}
