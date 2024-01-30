package com.example.streamsjava;

public class Cat {
    private String name;
    private String color;
    Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public String toString() {
        return "Cat[name=%s, color=%s]".formatted(this.name, this.color);
    }
}
