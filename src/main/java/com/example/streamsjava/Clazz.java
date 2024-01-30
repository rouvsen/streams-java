package com.example.streamsjava;

import java.util.Arrays;
import java.util.List;

public class Clazz {
    public static void main(String[] args) {

        List<Double> temps = Arrays.asList(
                98.4, 100.2, 87.9, 102.8
        );

        System.out.println(
                "Count of bigger than > 100 : " +
                        temps.stream()
                                .peek(System.out::println) //intermediate > chain(#1 super)
                                .filter(temp -> temp > 100) //intermediate > chain(#1 child of super)
                                .peek(System.out::println) //intermediate > chain(#1 child of child)
                                .count() //terminal (execute)
        );

    }
}
