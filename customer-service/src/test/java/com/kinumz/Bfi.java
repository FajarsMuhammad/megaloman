package com.kinumz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Bfi {

    @Test
    public void swap() {
        int a = 10;
        int b = 25;
        int c = 15;
        int res = 0;
        while (b > 0) {
            res += (a % c) + (c % a);
            b -= a % c;
            a = c;
        }
        System.out.println(res);
    }

    @Test
    void closestNumber() {
        List<Integer> numbers = Arrays.asList(3, 2, 1, 4);
        Collections.sort(numbers);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < numbers.size(); i++) {
            Integer first = numbers.get(i);
            Integer second = numbers.get(i - 1);
            int diff = first - second;
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        for (int i = 1; i < numbers.size(); i++) {
            Integer first = numbers.get(i);
            Integer second = numbers.get(i - 1);
            int diff = first - second;
            if (diff == minDiff) {
                System.out.println(second+" "+ first);
            }
        }
    }

    public static int countIncorrectPositions() {
        // Create a sorted copy of the heights list
        List<Integer> heights =Arrays.asList(1,1,3,3,4,1);
        List<Integer> sortedHeights = new ArrayList<>(heights);
        Collections.sort(sortedHeights);

        // Count the number of incorrect positions
        int incorrectCount = 0;
        for (int i = 0; i < heights.size(); i++) {
            if (!heights.get(i).equals(sortedHeights.get(i))) {
                incorrectCount++;
            }
        }

        return incorrectCount;
    }

}
