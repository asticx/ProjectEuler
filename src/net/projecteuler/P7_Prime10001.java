/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
 * https://projecteuler.net/problem=7
 *
 * @author jeffrey
 */
public class P7_Prime10001 {

    public static void main(String[] args) {
        System.out.println(getPrime(10001));
    }

    private static int getPrime(int index) {
        int count = 0;
        
        List<Integer> primes;
        primes = new ArrayList<>();

        for (int i = 2;; i++) {
            if(isPrime(i, primes)) {
                count ++;
                if (count == index) {
                    return i;
                }
            }
        }
    }

    private static boolean isPrime(int input, List<Integer> primes) {
        if (input == 2 || input == 3) {
            primes.add(input);
            return true;
        }

        int sqrt = (int) Math.sqrt(input);
        for (int prime : primes) {
            if (prime > sqrt) {
                break;
            }

            if (input % prime == 0) {
                return false;
            }
        }

        primes.add(input);
        return true;
    }
}
