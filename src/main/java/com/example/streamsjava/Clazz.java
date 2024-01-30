package com.example.streamsjava;

import java.util.*;
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

        System.out.println("""
                    
                    ***********************                
                    ***********************                
                """);

        //Ex 4, Set a limit for any Stream
        Stream.of("Alex", "Ben", "Charlie", "April", "Edward")
                .filter(el -> {
                    System.out.println("filter1: " + el);
                    return el.startsWith("B") || el.startsWith("C");
                })
                .filter(el -> {
                    System.out.println("filter2: " + el);
                    return el.length() > 3;
                })
                .limit(1)
                .forEach(System.out::println);

        System.out.println("""
                    
                    ***********************                
                    ***********************                
                """);

        //Ex 5, count (Terminal operation)
        String[] arr = {"Alex", "Ben", "Charlie", "April", "Edward"};
        Stream<String> stream = Arrays.stream(arr);
        long l = stream.count();
        System.out.println("Sum of Stream elements: " + l);

        System.out.println("""
                    
                    ***********************                
                    ***********************                
                """);

        //Ex 6, How can I use Map with Streams? Convert to Set because Set is a Collection > EntrySet() < Set View
        Map<String, Integer> map = new HashMap<>();
        map.put("Alex", 22); map.put("David", 27); map.put("Mary", 30);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println("=====");
        System.out.println(entries);
        System.out.println("=====");

        long mapCount = map.entrySet().stream().count();
        long mapCount2 = map.entrySet().size();
        System.out.println("Size of Map: " + mapCount);
        System.out.println("Size of Map: " + mapCount2);

        //Stream.of() static and generically-typed method
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        System.out.println("Count of Integer: " + integerStream.count());
        Stream<String> stringStream = Stream.of("A", "B", "C");
        System.out.println("Count of String: " + stringStream.count());
        Stream<Dog> dogStream = Stream.of(new Dog(), new Dog(), new Dog());
        System.out.println("Count of Dog: " + dogStream.count());
    }
}
