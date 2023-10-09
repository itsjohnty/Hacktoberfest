import java.util.Arrays;

public class PancakeSort {
    static void flip(int arr[], int i)
    {
        int temp, start = 0;
        while (start < i)
        {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }
 
    // Returns index of the maximum element in  arr[0..n-1] 
    static int findMax(int arr[], int n)
    {
        int mi, i;
        for (mi = 0, i = 0; i < n; ++i)
            if (arr[i] > arr[mi])
                mi = i;
        return mi;
    }
    void pancakesort(int arr[], int size){

        for (int curr_size = size; curr_size > 1; curr_size--)
        {
            // Find index of the maximum element in arr[0..curr_size-1]
            int mi = findMax(arr, curr_size);
 
            // Move the maximum element to end of current array if it's not already at the end
            if (mi != curr_size-1)
            {
                // To move at the end, first move maximum number to beginning
                flip(arr, mi);
 
                // Now move the maximum number to end by reversing current array
                flip(arr, curr_size-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 1, 2, 9, 8, 6 };
        int size = arr.length;
        PancakeSort ps = new PancakeSort();
        ps.pancakesort(arr, size);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(arr));
    }
}
