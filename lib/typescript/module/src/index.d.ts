interface Headers {
    [key: string]: string;
}
interface NetworkResponse<T> {
    data: T;
    status: number;
    headers: Headers;
}
export declare const NetworkModule: {
    get<T>(url: string, token?: string, params?: Object): Promise<NetworkResponse<T>>;
    post<T>(url: string, data?: object, token?: string): Promise<NetworkResponse<T>>;
    put<T>(url: string, data?: object, token?: string): Promise<NetworkResponse<T>>;
    patch<T>(url: string, data?: object, token?: string): Promise<NetworkResponse<T>>;
    deleteRequest<T>(url: string, data?: object, token?: string): Promise<NetworkResponse<T>>;
};
export {};
//# sourceMappingURL=index.d.ts.map