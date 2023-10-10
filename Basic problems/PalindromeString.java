import java.util.Scanner;

class Main {
    public static boolean isPalindrome(String s) {
        int st = 0;
        int e = s.length()-1;
        while(st<e){
            if(s.charAt(st)!=s.charAt(e)) return false;
            else {
                st++;
                e--;
            }
        }
        return true;
    }
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String a = scanner.next();
      
        boolean result = isPalindrome(a);

        if (result) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}