package VariableDicisionLoop;

public class PalindromeRecursion {
    public static boolean isPalindrome(String s, int left, int right){
        if (left >= right){
            return true;
        }

        if (s.charAt(left) != s.charAt(right)){
            return false;
        }

        return isPalindrome(s, left + 1, right - 1);
    }

    public static void main(String[] args){
        String input = "ABCDCBA";
        boolean result = isPalindrome(input, 0, input.length() - 1);
        System.out.println(result);
    }

}
