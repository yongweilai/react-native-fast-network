import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-fast-network' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

interface Headers {
  [key: string]: string;
}

interface NetworkResponse<T> {
  data: T;
  status: number;
  headers: Headers;
}

const FastNetwork = NativeModules.FastNetwork
  ? NativeModules.FastNetwork
  : new Proxy(
    {},
    {
      get() {
        throw new Error(LINKING_ERROR);
      },
    }
  );

export const NetworkModule = {
  async get<T>(url: string, token?: string, params?: Object): Promise<NetworkResponse<T>> {
    const response = await FastNetwork.get(url, token, params);
    return response;
  },
  async post<T>(url: string, data?: object, token?: string): Promise<NetworkResponse<T>> {
    const response = await FastNetwork.post(url, data, token);
    return response;
  },
  async put<T>(url: string, data?: object, token?: string): Promise<NetworkResponse<T>> {
    const response = await FastNetwork.put(url, data, token);
    return response;
  },
  async patch<T>(url: string, data?: object, token?: string): Promise<NetworkResponse<T>> {
    const response = await FastNetwork.patch(url, data, token);
    return response;
  },
  async deleteRequest<T>(url: string, data?: object, token?: string): Promise<NetworkResponse<T>> {
    const response = await FastNetwork.deleteRequest(url, data, token);
    return response;
  },
};
