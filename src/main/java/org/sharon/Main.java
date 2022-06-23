package org.sharon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter string");

        String str = myObj.nextLine();  // Read user input

        Scanner myOper = new Scanner(System.in);
        System.out.println("Do You Want To Encode Or Decode? Enter E For Encode Or D For Decode");

        String oper = myOper.nextLine();  // Read user input

        if (oper.equalsIgnoreCase("E")) {
            System.out.println(Main.encode(str, 25));
        }

        else if(oper.equalsIgnoreCase("D")) {
            System.out.println(Main.decode(Main.encode(str, 25), 25));
        }

        else {
            System.out.println("Please Select A Valid Option Between E & D!");
        }
    }
    public static String decode(String enc, int offset) {
        return encode(enc, 26-offset);
}

    public static String encode(String enc, int offset) {
        offset = offset % 26 + 26;
        StringBuilder encoded = new StringBuilder();
        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) ('A' + (i - 'A' + offset) % 26 ));
                } else {
                    encoded.append((char) ('a' + (i - 'a' + offset) % 26 ));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }
}