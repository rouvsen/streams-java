package com.example.streamsjava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Clazz {
    public static void main(String[] args) {

        //Ex 1
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

        //Ex 2
        Stream.of("Alex", "David", "April", "Edward")
                .filter(el -> {
                    System.out.println("Filter: " + el);
                    return true;
                })
                .forEach(el -> System.out.println("forEach: " + el));

        System.out.println("""
                    
                    ***********************                
                    ***********************                
                """);

        //Ex 3, Streams are Lazy, alright show me that in example
        Stream.of("Alex", "David", "April", "Edward")
                .map(el -> {
                    System.out.println("map: " + el);
                    return el.toUpperCase();
                })
                .anyMatch(el -> {
                    System.out.println("anyMatch: " + el);
                    return el.startsWith("A");
                });
    }
}
