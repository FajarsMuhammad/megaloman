package com.kinumz;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

public class FajarTest {

    SessionFactory sessionFactory;

    @Test
    public void SessionTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5, 6, 3, 7, 8, 2, 4, 9, 7, 1, 5, 10);
        Map<Integer, Integer> numberCountMap = new HashMap<>();

        Collections.emptyList();

        // Count occurrences of each number in the list
        for (int number : numbers) {
            numberCountMap.put(number, numberCountMap.getOrDefault(number, 0) + 1);
        }

        // Find duplicates and their counts
        System.out.println("Duplicate numbers and their counts:");
        for (Map.Entry<Integer, Integer> entry : numberCountMap.entrySet()) {
            if (entry.getValue() == 2) {
                System.out.println("Number: " + entry.getKey() + ", Count: " + entry.getValue());
            }
        }
    }

    @Test
    public void analogousArrays(){

        List<Integer> numbers = Arrays.asList(-2, -1,-2,5);
        int result = 0;
        int lowedBand = 3;
        int upper = 10;
        int substraction = lowedBand;
        for(Integer value : numbers){
            result = substraction - value;
            substraction = result;
        }
        System.out.println(result);


    }

}
