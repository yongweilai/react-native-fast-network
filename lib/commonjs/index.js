"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.NetworkModule = void 0;
var _reactNative = require("react-native");
const LINKING_ERROR = `The package 'react-native-fast-network' doesn't seem to be linked. Make sure: \n\n` + _reactNative.Platform.select({
  ios: "- You have run 'pod install'\n",
  default: ''
}) + '- You rebuilt the app after installing the package\n' + '- You are not using Expo Go\n';
const FastNetwork = _reactNative.NativeModules.FastNetwork ? _reactNative.NativeModules.FastNetwork : new Proxy({}, {
  get() {
    throw new Error(LINKING_ERROR);
  }
});
const NetworkModule = exports.NetworkModule = {
  async get(url, token, params) {
    const response = await FastNetwork.get(url, token, params);
    return response;
  },
  async post(url, data, token) {
    const response = await FastNetwork.post(url, data, token);
    return response;
  },
  async put(url, data, token) {
    const response = await FastNetwork.put(url, data, token);
    return response;
  },
  async patch(url, data, token) {
    const response = await FastNetwork.patch(url, data, token);
    return response;
  },
  async deleteRequest(url, data, token) {
    const response = await FastNetwork.deleteRequest(url, data, token);
    return response;
  }
};
//# sourceMappingURL=index.js.map