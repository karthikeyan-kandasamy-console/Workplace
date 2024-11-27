
# Exception Handling in Java

Exception handling in Java is a powerful mechanism that allows you to handle runtime errors, ensuring the normal flow of the application. Java provides a robust exception handling framework to catch, handle, and report errors that occur during the program’s execution.

## Key Concepts in Exception Handling:

1.  **Exception**: An object that describes an exceptional condition (error or problem) that occurs during the execution of a program.

2.  **Throwable**: The superclass of all errors and exceptions in Java. It has two main subclasses:

-  **Error**: Represents serious problems that a program usually cannot recover from (e.g., `OutOfMemoryError`).

-  **Exception**: Signals conditions that a program might want to catch and handle (e.g., `IOException`, `ArithmeticException`).

  

## Types of Exceptions:

1.  **Checked Exceptions**: Exceptions that are checked at compile time. They are subclasses of `Exception`, excluding `RuntimeException` and its subclasses.

- Example: `IOException`, `SQLException`

2.  **Unchecked Exceptions**: Exceptions that are not checked at compile time. They are subclasses of `RuntimeException`.

- Example: `NullPointerException`, `ArithmeticException`


3.  **Errors**: Severe conditions that typically cannot be handled by the program (e.g., `OutOfMemoryError`).
