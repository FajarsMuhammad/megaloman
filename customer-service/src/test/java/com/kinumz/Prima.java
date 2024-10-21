package com.kinumz;

import org.junit.jupiter.api.Test;

public class Prima {

    public String prime(int value) {
        StringBuilder builder = new StringBuilder();
        for (int i = 2; i <= value; i++) {
            if (isPrime(i)) {
                builder.append(i).append(" ");
            }
        }

        return builder.toString();
    }

    private boolean isPrime(int value) {
        System.out.println(Math.sqrt(value));
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void primeTest() {
        System.out.println(prime(100));
    }

}
