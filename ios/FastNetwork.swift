import Foundation
import React

@objc(FastNetwork)
class FastNetwork: NSObject {

    private let session = URLSession.shared

    @objc
    func get(_ url: String, token: String?, params: NSDictionary?, resolver: @escaping RCTPromiseResolveBlock, rejecter: @escaping RCTPromiseRejectBlock) {
        executeRequest(url: url, token: token, method: "GET", data: nil, resolver: resolver, rejecter: rejecter)
    }

    @objc
    func post(_ url: String, data: NSDictionary?, token: String?, resolver: @escaping RCTPromiseResolveBlock, rejecter: @escaping RCTPromiseRejectBlock) {
        let body = data?.toJsonRequestBody()
        executeRequest(url: url, token: token, method: "POST", data: body, resolver: resolver, rejecter: rejecter)
    }

    @objc
    func put(_ url: String, data: NSDictionary?, token: String?, resolver: @escaping RCTPromiseResolveBlock, rejecter: @escaping RCTPromiseRejectBlock) {
        let body = data?.toJsonRequestBody()
        executeRequest(url: url, token: token, method: "PUT", data: body, resolver: resolver, rejecter: rejecter)
    }

    @objc
    func patch(_ url: String, data: NSDictionary?, token: String?, resolver: @escaping RCTPromiseResolveBlock, rejecter: @escaping RCTPromiseRejectBlock) {
        let body = data?.toJsonRequestBody()
        executeRequest(url: url, token: token, method: "PATCH", data: body, resolver: resolver, rejecter: rejecter)
    }

    @objc
    func deleteRequest(_ url: String, data: NSDictionary?, token: String?, resolver: @escaping RCTPromiseResolveBlock, rejecter: @escaping RCTPromiseRejectBlock) {
        let body = data?.toJsonRequestBody()
        executeRequest(url: url, token: token, method: "DELETE", data: body, resolver: resolver, rejecter: rejecter)
    }

    private func executeRequest(url: String, token: String?, method: String, data: Data?, resolver: @escaping RCTPromiseResolveBlock, rejecter: @escaping RCTPromiseRejectBlock) {
        guard let requestUrl = URL(string: url) else {
            rejecter("Invalid URL", "The provided URL is not valid", nil)
            return
        }

        var request = URLRequest(url: requestUrl)
        request.httpMethod = method
        if let token = token {
            request.setValue("Bearer \(token)", forHTTPHeaderField: "Authorization")
        }
        if let data = data {
            request.httpBody = data
            request.setValue("application/json", forHTTPHeaderField: "Content-Type")
        }

        let task = session.dataTask(with: request) { data, response, error in
            if let error = error {
                rejecter("Network request failed", error.localizedDescription, error)
                return
            }

            guard let httpResponse = response as? HTTPURLResponse, let data = data else {
                rejecter("Network request failed", "Invalid response or data", nil)
                return
            }

            var responseMap = [String: Any]()
            responseMap["status"] = httpResponse.statusCode
            responseMap["headers"] = httpResponse.allHeaderFields

            if let responseData = try? JSONSerialization.jsonObject(with: data, options: []) {
                responseMap["data"] = responseData
            } else {
                responseMap["data"] = String(data: data, encoding: .utf8)
            }

            resolver(responseMap)
        }

        task.resume()
    }
}

private extension NSDictionary {
    func toJsonRequestBody() -> Data? {
        if let jsonData = try? JSONSerialization.data(withJSONObject: self, options: []) {
            return jsonData
        }
        return nil
    }
}
