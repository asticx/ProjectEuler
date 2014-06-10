/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
 * https://projecteuler.net/problem=8
 *
 * @author jeffrey
 */
public class P8_ConsecutiveDigit {

    public static void main(String[] args) {
        String input
                = "73167176531330624919225119674426574742355349194934"
                + "96983520312774506326239578318016984801869478851843"
                + "85861560789112949495459501737958331952853208805511"
                + "12540698747158523863050715693290963295227443043557"
                + "66896648950445244523161731856403098711121722383113"
                + "62229893423380308135336276614282806444486645238749"
                + "30358907296290491560440772390713810515859307960866"
                + "70172427121883998797908792274921901699720888093776"
                + "65727333001053367881220235421809751254540594752243"
                + "52584907711670556013604839586446706324415722155397"
                + "53697817977846174064955149290862569321978468622482"
                + "83972241375657056057490261407972968652414535100474"
                + "82166370484403199890008895243450658541227588666881"
                + "16427171479924442928230863465674813919123162824586"
                + "17866458359124566529476545682848912883142607690042"
                + "24219022671055626321111109370544217506941658960408"
                + "07198403850962455444362981230987879927244284909188"
                + "84580156166097919133875499200524063689912560717606"
                + "05886116467109405077541002256983155200055935729725"
                + "71636269561882670428252483600823257530420752963450";

        int len = input.length();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = Integer.valueOf(input.substring(i, i + 1));
        }

        System.out.println(maxConsecutiveRaw(array, 13));
    }
    
    /**
     * 1. Split the original array into several integer arrays, each array will NOT
     * contain 0 and each array's length should be equal or greator than the
     * consecutiveNumber.
     * 
     * 2. For each array, calculate its max value.
     * 
     * 3. Return the max value for the whole array.
     * 
     * @param array
     * @param consecutiveNumber
     * @return 
     */
    private static long maxConsecutiveRaw(int[] array, int consecutiveNumber) {
        long result = 0;

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (list.size() >= consecutiveNumber) {
                    long temp = maxConsecutive(list, consecutiveNumber);
                    if (temp > result) {
                        result = temp;
                    }
                }

                list.clear();
            } else {
                list.add(array[i]);
            }
        }

        if (list.size() >= consecutiveNumber) {
            long temp = maxConsecutive(list, consecutiveNumber);
            if (temp > result) {
                result = temp;
            }
        }

        return result;
    }

    private static long maxConsecutive(List<Integer> list, int consecutiveNumber) {
        long result = 1;
        for (int i = 0; i < consecutiveNumber; i++) {
            result = result * list.get(i);
        }

        long temp = result;

        long loop = list.size() - consecutiveNumber;
        for (int i = 0; i < loop; i++) {
            temp = temp / list.get(i) * list.get(i + consecutiveNumber);
            if (temp > result) {
                result = temp;
            }
        }

        return result;
    }

}
