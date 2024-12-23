
### React Hooks

React **Hooks** are functions that let you "hook into" React state and lifecycle features from function components. Hooks were introduced in React 16.8 to allow function components to have features like state, lifecycle methods, and side effects, which were previously only available in class components.

Here's a brief overview of the most commonly used hooks in React:

----------

### 1. **useState**

The `useState` hook allows you to add state to function components. It returns an array with two elements:

-   The current state value.
-   A function to update that value.

#### Example:

```
import React, { useState } from 'react';

function Counter() {
  // Declare a state variable `count`, initialized to 0
  const [count, setCount] = useState(0);

  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>
  );
}
```
 


-   **`useState(0)`** initializes the state variable `count` to 0.
-   **`setCount(count + 1)`** is used to update the state.

----------

### 2. **useEffect**

The `useEffect` hook allows you to perform side effects in function components, such as data fetching, subscriptions, or manually changing the DOM.

By default, `useEffect` runs after every render, but you can control when it runs by passing dependencies.

#### Example:



```
 import React, { useState, useEffect } from 'react';

function FetchData() {
  const [data, setData] = useState(null);

  useEffect(() => {
    fetch('https://api.example.com/data')
      .then(response => response.json())
      .then(data => setData(data));
  }, []); // Empty dependency array means it only runs once (on mount)

  return <div>{data ? JSON.stringify(data) : 'Loading...'}</div>;
}
```
 

-   The `useEffect` hook here fetches data when the component mounts (because of the empty dependency array `[]`).
-   The effect runs **only once** when the component mounts and fetches the data.

----------

### 3. **useContext**

The `useContext` hook allows you to access the value of a React context. This is useful when you want to pass data down the component tree without having to pass props at every level.

#### Example:



```
 import React, { useState, useContext, createContext } from 'react';

// Create a Context
const ThemeContext = createContext();

function ThemedComponent() {
  const theme = useContext(ThemeContext);
  return <div style={{ background: theme.background, color: theme.color }}>Themed Content</div>;
}

function App() {
  const [theme, setTheme] = useState({ background: 'black', color: 'white' });

  return (
    <ThemeContext.Provider value={theme}>
      <ThemedComponent />
      <button onClick={() => setTheme({ background: 'white', color: 'black' })}>Change Theme</button>
    </ThemeContext.Provider>
  );
}
```
 

-   **`useContext(ThemeContext)`** accesses the current value of the `ThemeContext` within the component.

----------

### 4. **useRef**

The `useRef` hook allows you to persist values across renders without causing a re-render. It is often used for accessing DOM elements directly or for storing mutable values that do not trigger a re-render.

#### Example:



```
 import React, { useRef } from 'react';

function FocusInput() {
  const inputRef = useRef();

  const handleFocus = () => {
    inputRef.current.focus(); // Focus the input element
  };

  return (
    <div>
      <input ref={inputRef} />
      <button onClick={handleFocus}>Focus Input</button>
    </div>
  );
}
```
 

-   **`useRef()`** returns a mutable `ref` object, which can hold a reference to a DOM element or any value that persists across renders.

----------

### 5. **useReducer**

The `useReducer` hook is used for handling more complex state logic, especially when you have multiple sub-values or want to manage state transitions in a more predictable way.

It works like `useState` but gives you more control over the state with a reducer function, similar to Redux.

#### Example:



```
 import React, { useReducer } from 'react';

// Define the reducer function
function counterReducer(state, action) {
  switch (action.type) {
    case 'increment':
      return { count: state.count + 1 };
    case 'decrement':
      return { count: state.count - 1 };
    default:
      return state;
  }
}

function Counter() {
  const [state, dispatch] = useReducer(counterReducer, { count: 0 });

  return (
    <div>
      <p>Count: {state.count}</p>
      <button onClick={() => dispatch({ type: 'increment' })}>Increment</button>
      <button onClick={() => dispatch({ type: 'decrement' })}>Decrement</button>
    </div>
  );
}
```
 

-   **`useReducer(counterReducer, { count: 0 })`** sets the initial state and the reducer function.
-   **`dispatch({ type: 'increment' })`** is used to send actions to the reducer.

----------

### 6. **useMemo**

The `useMemo` hook memoizes the result of a calculation and only recalculates it when the dependencies change. This is useful for expensive computations that you want to avoid recalculating on every render.

#### Example:



```
 import React, { useMemo, useState } from 'react';

function ExpensiveComputation({ number }) {
  const computedValue = useMemo(() => {
    console.log('Computing...');
    return number * 2;
  }, [number]); // Only recompute when `number` changes

  return <div>Computed Value: {computedValue}</div>;
}

function App() {
  const [number, setNumber] = useState(0);

  return (
    <div>
      <ExpensiveComputation number={number} />
      <button onClick={() => setNumber(number + 1)}>Increment</button>
    </div>
  );
}
```
 

-   **`useMemo()`** is used here to avoid recalculating `computedValue` unless `number` changes.

----------

### 7. **useCallback**

The `useCallback` hook is similar to `useMemo` but is used for memoizing functions. It ensures that a function is only recreated if one of its dependencies has changed.

#### Example:



```
 import React, { useState, useCallback } from 'react';

function ChildComponent({ onClick }) {
  return <button onClick={onClick}>Click me</button>;
}

function ParentComponent() {
  const [count, setCount] = useState(0);

  // Memoize the `handleClick` function
  const handleClick = useCallback(() => {
    setCount(count + 1);
  }, [count]);

  return (
    <div>
      <ChildComponent onClick={handleClick} />
      <p>Count: {count}</p>
    </div>
  );
}
```
 

-   **`useCallback()`** ensures that `handleClick` is only recreated when `count` changes, preventing unnecessary re-renders of `ChildComponent`.

----------

### 8. **useLayoutEffect**

`useLayoutEffect` is similar to `useEffect`, but it runs synchronously after all DOM mutations. It is useful when you need to read or modify the DOM before the browser repaints.

#### Example:



```
 import React, { useLayoutEffect, useState } from 'react';

function LayoutEffectExample() {
  const [width, setWidth] = useState(0);

  useLayoutEffect(() => {
    const handleResize = () => {
      setWidth(window.innerWidth);
    };
    window.addEventListener('resize', handleResize);

    return () => {
      window.removeEventListener('resize', handleResize);
    };
  }, []);

  return <div>Window width: {width}</div>;
}
```
 

-   **`useLayoutEffect()`** is used here to read the window width before the browser renders, ensuring that the DOM is updated synchronously with the layout changes.

----------

### Summary of React Hooks:

-   **`useState`**: Adds state to function components.
-   **`useEffect`**: Handles side effects like data fetching or subscriptions.
-   **`useContext`**: Accesses the value of a context.
-   **`useRef`**: Keeps a mutable reference to a DOM element or a value that persists across renders.
-   **`useReducer`**: Manages complex state logic, useful for handling multiple actions or sub-values.
-   **`useMemo`**: Memoizes the result of a calculation for performance optimization.
-   **`useCallback`**: Memoizes a function to avoid unnecessary re-creations.
-   **`useLayoutEffect`**: Similar to `useEffect`, but runs synchronously after DOM mutations.

Hooks provide a more flexible and functional way of managing state and side effects in React, enabling you to use features previously available only in class components while keeping your code more readable and concise.