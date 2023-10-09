class Solution{
    static int minJumps(int[] arr){
        // your code here
        int ans = 0;
        int end = -1;
        int max = 0;
        
        for(int i=0;i<arr.length-1;i+=1){
            if(i>end){
                ans+=1;
                end = max;
            }
            max = Math.max(max,arr[i]+i);
            if(max>=arr.length-1){
                return ans;
            }
            if(max<=i)
                return -1;
        }
        return ans;
    }
}
