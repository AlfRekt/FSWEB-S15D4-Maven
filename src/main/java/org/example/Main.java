package org.example;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(convertDecimalToBinary(13));;
    }

    public static boolean checkForPalindrome(String text){
        if (text == null) return false;
        StringBuilder cleaned = new StringBuilder();

        for (char c : text.toCharArray()) {

            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                cleaned.append(Character.toLowerCase(c));
            }
        }

        int left = 0;
        int right = cleaned.length() - 1;

        while(left < right){
            if(cleaned.charAt(left) != cleaned.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static String convertDecimalToBinary(int value){
        Map<String, Integer> remainderHolder = new LinkedHashMap<>();
        StringBuilder binary = new StringBuilder();

        int stepCount = 0;
        int quotient = value;

        if (value == 0) return "0";

        while(quotient > 0){
            int remainder = quotient % 2;
            quotient = quotient / 2;

            remainderHolder.put("digit " + stepCount, remainder);
            stepCount++;
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<>(remainderHolder.entrySet());
        Collections.reverse(list);

        for(Map.Entry<String,Integer> entry : list){
            binary.append(entry.getValue());
        }

        return binary.toString();
    }

}