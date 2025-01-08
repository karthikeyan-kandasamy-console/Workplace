
**React Router v5**

**Navigating Programmatically in a Class Component**: To navigate programmatically (for example, when a button is clicked), you use the `useNavigate` hook in function components, but in class components, you can use the `withRouter` higher-order component (HOC) or access the `history` object directly via `this.props.history` (in older versions of React Router).

  

```
	import React from 'react';  
	import { withRouter } from 'react-router-dom';  
	  
	class MyComponent extends React.Component {  
	navigateToAbout = () => {  
	this.props.history.push('/about');  
	};  
	  
	render() {  
	return (  
	<div>  
	<button onClick={this.navigateToAbout}>Go to About Page</button>  
	</div>  
	);  
	}  
	}  
	  
	export default withRouter(MyComponent);
```

**React Router v6**: In **React Router v6**, you'll need to wrap your class component with a function component that uses the `useNavigate` hook. Here’s how you can do it:

  

```
	import React from 'react';  
	import { useNavigate } from 'react-router-dom';  
	  
	// Wrapper function component  
	const NavigateWrapper = () => {  
	const navigate = useNavigate();  
	  
	return <MyComponent navigate={navigate} />;  
	};  
	  
	class MyComponent extends React.Component {  
	navigateToAbout = () => {  
	// Programmatically navigate to the About page  
	this.props.navigate('/about');  
	};  
	  
	render() {  
	return (  
	<div>  
	<button onClick={this.navigateToAbout}>Go to About Page</button>  
	</div>  
	);  
	}  
	}  
	  
	export default NavigateWrapper;
```

**Note : T**he fact that `withRouter` has been removed in **React Router v6**. In React Router v6, the `withRouter` HOC is no longer available. Instead, you need to use the `useNavigate` hook for programmatic navigation, but since you're working with class components, you'll need a workaround for this.