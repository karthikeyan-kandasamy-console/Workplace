package com.incvo.App;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortComparable {
    public static void main(String[] args) {

        Main.main(args);
        
    }
}


class Person implements Comparable<Person> {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age); 
    }
}

class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("John", 25),
            new Person("Alice", 30),
            new Person("Bob", 20)
        );
        Collections.sort(people); 
        for (Person person : people) {
            System.out.println(person.name + ": " + person.age);
        }
    }
}


