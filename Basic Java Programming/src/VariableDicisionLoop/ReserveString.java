package VariableDicisionLoop;

public class ReserveString {
    public static void main(String[] args){
        String str = "Welcome to Agest";
        String reserved = "";

        for (int i = str.length() - 1; i >= 0; i--){
            reserved += str.charAt(i);
        }

        System.out.println("Original: " + str);
        System.out.println("Reserved: " + reserved);
    }
}
