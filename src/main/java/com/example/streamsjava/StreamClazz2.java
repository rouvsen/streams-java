package com.example.streamsjava;

import com.fasterxml.jackson.core.JsonToken;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamClazz2 {

    private static String absolutePath = "C:\\workspace\\streams-java\\src\\main\\java\\com\\example\\streamsjava\\";
    public static void main2(String[] args) {
        List<Cat> cats = loadCats(absolutePath + "cats.txt");
        cats.forEach(System.out::println);

        Stream.generate(() -> (int)(Math.random() * 10))
                .limit(10)
                .forEach(el -> System.out.println("Random number: " + el));
        Stream.iterate(2, el -> el + 2).limit(3).forEach(System.out::println);
    }

    public static void main(String[] args) {
        //Terminal operators: forEach, min, max, findAny, findFirst, anyMatch..

        Optional<String> min = Stream.of("ABCD", "ABC", "AB", "ABCDE")
                .min(Comparator.comparingInt(String::length));
        System.out.println("String with min length: " + min.get());

        Optional<Integer> max = Stream.of(3,5,1,7)
                .max((a1, a2) -> a1 - a2);
        System.out.println("Number with max value: " + max.get());

        Optional<String> res1 = Stream.of("John", "Alexa")
                .findAny(); //John (usually);
        res1.ifPresent(System.out::println);

        Optional<String> res2 = Stream.of("Jerry", "Alex", "Den")
                .findFirst();
        res2.ifPresent(System.out::println);

        List<String> names = Arrays.asList("Alex", "Bob", "Catalina");
        Predicate<String> pred = name -> name.startsWith("A");
        System.out.println("matcher1: " + names.stream().anyMatch(pred)); //true, one does
        System.out.println("matcher2: " + names.stream().allMatch(pred)); //false, two doesn't
        System.out.println("matcher3: " + names.stream().noneMatch(pred)); //false, one does

        //forEach is not redundant, and return type of forEach is < void >
        //Collection interface contains a forEach method,
        //Stream doesn't implement Iterable that can not be source of forEach
        Stream<String> howAreYou = Stream.of("Hello, ", "How are ", "you?");
        howAreYou.forEach(System.out::print);
    }

    public static List<Cat> loadCats(String fileName) {
        List<Cat> cats = new ArrayList<>();
        try( Stream<String> catsString = Files.lines(Paths.get(fileName)) ) {
            catsString.forEach(el -> {
                String[] catsFromFile = el.split("/");
                cats.add(new Cat(catsFromFile[0], catsFromFile[1]));
            });
        } catch (IOException exception) {
            System.out.println("IO Process failed: " + exception.getCause());
        }
        return cats;
    }
}
