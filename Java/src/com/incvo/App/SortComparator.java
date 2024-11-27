package com.incvo.App;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortComparator {

    public static void main(String[] args) {
        List<Sample> people = Arrays.asList(
            new Sample("John", 25),
            new Sample("Alice", 30),
            new Sample("Bob", 20)
        );
        Collections.sort(people, new AgeComparator());  
        for (Sample person : people) {
            System.out.println(person.getName() + ": " + person.getAge());
        }

        System.out.println("----");

        Collections.sort(people, new NameComparator());  
        for (Sample person : people) {
            System.out.println(person.getName() + ": " + person.getAge());
        }
    }
    
}



class Sample {
    protected String name;
    protected int age;

    public Sample(String name, int age) {
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

class AgeComparator implements Comparator<Sample> {
    @Override
    public int compare(Sample p1, Sample p2) {
        return Integer.compare(p1.getAge(), p2.getAge());  
    }
}

class NameComparator implements Comparator<Sample> {
    @Override
    public int compare(Sample p1, Sample p2) {
        return p1.getName().compareTo(p2.getName());  
    }
}

