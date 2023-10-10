import java.util.*;
public class ArraySecondHighestNumber {

    public static void main(String[] args) {
        System.out.println("Enter the number of elements you want to input: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > highest) {
                secondHighest = highest;
                highest = j;
            } else {
                secondHighest = j;
            }
        }
        System.out.println(secondHighest);
    }
}
