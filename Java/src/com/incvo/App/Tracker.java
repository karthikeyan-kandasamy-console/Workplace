package com.incvo.App;

public class Tracker {
    public static void checkAge(int age) throws IllegalArgumentException {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older");
        }
        System.out.println("Age is valid: " + age);
    }

    public static void main(String[] args) {
        try {
            checkAge(16);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("Execution completed.");
        }
    }
}
