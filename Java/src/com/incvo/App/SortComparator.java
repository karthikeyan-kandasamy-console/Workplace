package com.incvo.App;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortComparator {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("John", 25),
            new Person("Alice", 30),
            new Person("Bob", 20)
        );
        Collections.sort(people, new AgeComparator());  
        for (Person person : people) {
            System.out.println(person.getName() + ": " + person.getAge());
        }

        System.out.println("----");

        Collections.sort(people, new NameComparator());  
        for (Person person : people) {
            System.out.println(person.getName() + ": " + person.getAge());
        }
    }
    
}



class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getAge(), p2.getAge());  
    }
}

class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());  
    }
}

