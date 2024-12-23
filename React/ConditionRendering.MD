
**Conditional rendering** in React refers to the concept of rendering different elements or components based on a specific condition. React provides several ways to conditionally render elements or components depending on the state, props, or other conditions.

Here are some common techniques for **conditional rendering** in React:

### 1. **Using `if` / `else` Statements**

You can use the traditional `if...else` statements to render different JSX based on conditions. This is often done inside a function component.

#### Example:


```
function Greeting({ isLoggedIn }) {
  if (isLoggedIn) {
    return <h1>Welcome back!</h1>;
  } else {
    return <h1>Please sign in.</h1>;
  }
}
```

In this example:

-   If `isLoggedIn` is `true`, it renders "Welcome back!".
-   If `isLoggedIn` is `false`, it renders "Please sign in."

### 2. **Using Ternary Operator**

The **ternary operator** is a compact form of the `if...else` statement, useful for rendering elements based on a condition.

#### Example:

```
function Greeting({ isLoggedIn }) {
  return (
    <h1>{isLoggedIn ? 'Welcome back!' : 'Please sign in.'}</h1>
  );
}
```
Here:

-   If `isLoggedIn` is `true`, it renders "Welcome back!".
-   If `isLoggedIn` is `false`, it renders "Please sign in."

### 3. **Using Logical `&&` Operator**

The **logical `&&` operator** is used to conditionally render something only when the condition is true. If the condition is `false`, it renders nothing.

#### Example:

```
function Greeting({ isLoggedIn }) {
  return (
    <div>
      {isLoggedIn && <h1>Welcome back!</h1>}
    </div>
  );
}
```
In this example:

-   If `isLoggedIn` is `true`, it renders "Welcome back!".
-   If `isLoggedIn` is `false`, it renders nothing (i.e., nothing is displayed).

### 4. **Returning `null` for No Rendering**

Sometimes you might want to render nothing based on certain conditions. In such cases, you can return `null`.

#### Example:

```
function Greeting({ isLoggedIn }) {
  if (!isLoggedIn) {
    return null;  // Nothing will be rendered if not logged in
  }
  return <h1>Welcome back!</h1>;
}
```
Here:

-   If `isLoggedIn` is `false`, it returns `null` and nothing is rendered.
-   If `isLoggedIn` is `true`, it renders "Welcome back!".

### 5. **Using Switch Statements**

For more complex conditions or multiple options, you might use a `switch` statement. While React doesn't support `switch` directly in JSX, you can use it in a function body to determine what to render.

#### Example:

```
function Greeting({ userRole }) {
  switch (userRole) {
    case 'admin':
      return <h1>Welcome Admin!</h1>;
    case 'user':
      return <h1>Welcome User!</h1>;
    case 'guest':
      return <h1>Welcome Guest!</h1>;
    default:
      return <h1>Please sign in.</h1>;
  }
}
```

In this case:

-   Based on the value of `userRole`, it renders different messages.

### 6. **Conditional Rendering with React Fragments**

Sometimes you may want to conditionally render multiple elements without adding extra DOM nodes. You can use `React.Fragment` to wrap multiple elements.

#### Example:

```
function UserProfile({ user }) {
  return (
    <>
      {user.isAdmin && <h1>Welcome, Admin!</h1>}
      <h2>{user.name}</h2>
    </>
  );
}
```

In this example:

-   If `user.isAdmin` is `true`, it shows "Welcome, Admin!" followed by the user's name.
-   Otherwise, it just shows the user's name without "Welcome, Admin!".

----------

### Summary of Common Techniques

-   **`if/else` statements**: Good for more complex conditions and returning different elements.
-   **Ternary operator (`condition ? true : false`)**: Good for concise, inline conditional rendering.
-   **Logical `&&` operator**: Renders something only if a condition is true, otherwise renders nothing.
-   **`null` return**: When you want to render nothing.
-   **Switch case**: Ideal for checking multiple conditions based on the same value.
-   **React Fragment**: To avoid extra DOM elements when conditionally rendering multiple elements.