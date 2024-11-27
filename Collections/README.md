
# Java Collections Framework

The **Java Collections Framework** provides a set of classes and interfaces that implement commonly used data structures, allowing developers to store, retrieve, and manipulate data in a variety of ways. It provides a unified architecture for working with different types of collections such as lists, sets, queues, and maps.

## Key Interfaces of Java Collections Framework

### 1. **Collection Interface**
The `Collection` interface is the root interface of the collection hierarchy. It represents a group of objects, known as elements.

- **Methods**:
  - `add(E e)`: Adds an element to the collection.
  - `remove(Object o)`: Removes an element from the collection.
  - `clear()`: Removes all elements from the collection.
  - `size()`: Returns the number of elements in the collection.
  - `isEmpty()`: Checks if the collection is empty.

### 2. **List Interface**
The `List` interface extends the `Collection` interface and represents an ordered collection that may contain duplicate elements.

- **Implementing Classes**: `ArrayList`, `LinkedList`, `Vector`, `Stack`
  
- **Methods**:
  - `add(int index, E element)`: Adds an element at the specified index.
  - `get(int index)`: Retrieves the element at the specified index.
  - `set(int index, E element)`: Replaces the element at the specified index.
  - `remove(int index)`: Removes the element at the specified index.

### 3. **Set Interface**
The `Set` interface extends `Collection` and represents a collection that does not allow duplicate elements.

- **Implementing Classes**: `HashSet`, `LinkedHashSet`, `TreeSet`
  
- **Methods**:
  - `add(E e)`: Adds an element to the set (only if not already present).
  - `remove(Object o)`: Removes the element from the set.
  - `contains(Object o)`: Checks if the element exists in the set.
  - `size()`: Returns the number of elements in the set.

### 4. **Queue Interface**
The `Queue` interface represents a collection designed for holding elements before processing. It is typically used to model a queue of tasks, where elements are processed in FIFO (First In First Out) order.

- **Implementing Classes**: `LinkedList`, `PriorityQueue`
  
- **Methods**:
  - `add(E e)`: Inserts the specified element into the queue.
  - `peek()`: Retrieves, but does not remove, the head of the queue.
  - `poll()`: Retrieves and removes the head of the queue.
  - `offer(E e)`: Adds an element to the queue (may fail or return false if the queue is full).

### 5. **Map Interface**
The `Map` interface represents a collection of key-value pairs. It maps keys to values, where each key is associated with exactly one value.

- **Implementing Classes**: `HashMap`, `LinkedHashMap`, `TreeMap`
  
- **Methods**:
  - `put(K key, V value)`: Adds a key-value pair to the map.
  - `get(Object key)`: Retrieves the value associated with the key.
  - `containsKey(Object key)`: Checks if a key exists in the map.
  - `remove(Object key)`: Removes the key-value pair for the given key.

---

## Common Implementing Classes

### 1. **ArrayList**
An `ArrayList` is a resizable array implementation of the `List` interface. It allows dynamic resizing and provides fast random access to elements.

- **Characteristics**:
  - Allows duplicate elements.
  - Elements are ordered.
  - Provides O(1) time complexity for accessing elements by index.
  
```java
List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
