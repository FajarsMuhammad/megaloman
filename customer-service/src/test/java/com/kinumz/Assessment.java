package com.kinumz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Assessment {

    @Test
    public void JumpTest() {
        int values[] = {0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0};
        System.out.println(jump(values));
    }

    private static int jump(int arr[]) {
        int skipJump = 0;
        int jump = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 1) {
                continue;
            }
            if (i == arr.length - 1) {
                return jump;
            }
            int next = arr[i++];
            if (arr[i] == next) {
                jump++;
                skipJump++;
            }
            if (skipJump > 2) {
                skipJump = 0;
                continue;
            }
            jump++;
        }

        return jump;
    }

    @Test
    public void stringTest() {

        String test = new String("Data");
        String test2 = "Data";

        Assertions.assertFalse(test == test2);
        Assertions.assertTrue(test.equals(test2));

    }
}