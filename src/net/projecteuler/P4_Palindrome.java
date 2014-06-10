/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.projecteuler;

/**
 * https://projecteuler.net/problem=7
 *
 * @author jeffrey
 */
public class P4_Palindrome {
    
    public static void main(String[] args) {
        System.out.println(getDedicatedPalindrome());
    }

    private static int getDedicatedPalindrome() {
        int result = -1;

        // 11 must be one factor of the 6-digit palindrome 
        for (int i = 990; i >= 110; i = i - 11) {
            for (int j = 999; j >= 100; j--) {
                int temp = i * j;
                if (temp > result && isPalindrome(temp)) {
                    result = temp;
                }
            }
        }
        
        return result;
    }

    private static boolean isPalindrome(int number) {
        int div = 1;
        while(number / div >= 10) {
            div = div * 10;
        }
        
        while(number != 0) {
            int head = number / div;
            int last = number % 10;
            if (head != last) {
                return false;
            }
            
            number = (number % div) / 10;
            div = div / 100;
        }
        
        return true;
    }
}
