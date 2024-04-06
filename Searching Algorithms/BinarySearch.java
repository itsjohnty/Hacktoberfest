// Time complexity: O(logN)
// Space complexity: O(1)

import java.util.*;

public class BinarySearch {

    //Binary Search implementation
    public static int BinarySearch(int []arr, int target){
        int low =0, high=arr.length -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //Size of Array
        System.out.println("Enter the number of elements present in an array.");
        int n = sc.nextInt();

        //Array Declaration and Inputting Elements into it
        System.out.println("Enter the elements: ");
        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        //Getting target value
        System.out.println("Enter the target element present in the array");
        int x = sc.nextInt();

        //Function Calling 
        int result = BinarySearch(arr,x);
        

        if(result == 0){
            System.out.println("The element is not present in an array");
        }
        else{
            System.out.println("The element found at the index: "+result);
        }
    }
}
