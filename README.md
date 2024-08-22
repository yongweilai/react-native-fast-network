# react-native-fast-network

React Native Fast Network Library

The React Native Fast Network library is a lightweight, easy-to-use networking module that provides a simple API for making HTTP requests in React Native applications. This library supports various HTTP methods like GET, POST, PUT, PATCH, and DELETE, along with support for custom headers, parameters, and request bodies.

## Installation

```sh
npm install react-native-fast-network
```
or

```sh
yarn add react-native-fast-network
```

## iOS Setup

```sh
cd ios
pod install

```

## Rebuild the app
After installation, rebuild your app to include the native modules:
```sh
npx react-native run-android
npx react-native run-ios

```


## Usage

The library provides an easy-to-use interface for making HTTP requests. Here's how you can use it:

Importing the module
```js
import { NetworkModule } from 'react-native-fast-network';
```

## Making Requests
## GET Request:
```js
const fetchItems = async () => {
  try {
    const response = await NetworkModule.get('https://api.example.com/items');
    console.log('Fetched items:', response.data);
  } catch (error) {
    console.error('Error fetching items:', error);
  }
};

```

## POST Request:
```js
const createItem = async (newItem) => {
  try {
    const response = await NetworkModule.post('https://api.example.com/items', newItem);
    console.log('Created item:', response.data);
  } catch (error) {
    console.error('Error creating item:', error);
  }
};


```

## PUT Request:
```js
const updateItem = async (id, updatedItem) => {
  try {
    const response = await NetworkModule.put(`https://api.example.com/items/${id}`, updatedItem);
    console.log('Updated item:', response.data);
  } catch (error) {
    console.error('Error updating item:', error);
  }
};
```

## PATCH Request
```js
const patchItem = async (id, partialItem) => {
  try {
    const response = await NetworkModule.patch(`https://api.example.com/items/${id}`, partialItem);
    console.log('Patched item:', response.data);
  } catch (error) {
    console.error('Error patching item:', error);
  }
};

```

## DELETE Request
```js
const deleteItem = async (id) => {
  try {
    const response = await NetworkModule.deleteRequest(`https://api.example.com/items/${id}`);
    console.log('Deleted item:', response.data);
  } catch (error) {
    console.error('Error deleting item:', error);
  }
};

```

## Handling Headers and Tokens

You can pass custom headers, such as authorization tokens, by including them in the request:
```js
const fetchItemsWithAuth = async () => {
  try {
    const token = 'your-auth-token';
    const response = await NetworkModule.get('https://api.example.com/items', token);
    console.log('Fetched items:', response.data);
  } catch (error) {
    console.error('Error fetching items:', error);
  }
};
```

## Network Response Structure

The NetworkModule returns a Promise that resolves to an object with the following structure:
the request:
```js
interface NetworkResponse<T> {
  data: T;
  status: number;
  headers: { [key: string]: string };
}
```

## Error Handling
Errors can be handled using standard JavaScript try-catch blocks:
```js
try {
  const response = await NetworkModule.get('https://api.example.com/items');
  console.log(response.data);
} catch (error) {
  console.error('An error occurred:', error);
}
```

## Conclusion
The React Native Fast Network library is a robust solution for making HTTP requests in your React Native applications. It supports all major HTTP methods and provides a consistent, easy-to-use API for handling network requests and responses.

Feel free to contribute to the library on GitHub, and don't hesitate to open issues if you encounter any problems!

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
