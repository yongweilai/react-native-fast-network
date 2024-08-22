#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(FastNetwork, NSObject)

RCT_EXTERN_METHOD(get:(NSString *)url
                 token:(NSString *)token
                 params:(NSDictionary *)params
                 resolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject)

RCT_EXTERN_METHOD(post:(NSString *)url
                 data:(NSDictionary *)data
                 token:(NSString *)token
                 resolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject)

RCT_EXTERN_METHOD(put:(NSString *)url
                 data:(NSDictionary *)data
                 token:(NSString *)token
                 resolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject)

RCT_EXTERN_METHOD(patch:(NSString *)url
                 data:(NSDictionary *)data
                 token:(NSString *)token
                 resolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject)

RCT_EXTERN_METHOD(deleteRequest:(NSString *)url
                 data:(NSDictionary *)data
                 token:(NSString *)token
                 resolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject)

@end
