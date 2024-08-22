
/**
 * This code was generated by [react-native-codegen](https://www.npmjs.com/package/react-native-codegen).
 *
 * Do not edit this file as changes may cause incorrect behavior and will be lost
 * once the code is regenerated.
 *
 * @generated by codegen project: GenerateEventEmitterCpp.js
 */

#include <react/renderer/components/ReactNativeFastNetworkSpec/EventEmitters.h>


namespace facebook::react {


void AndroidDrawerLayoutEventEmitter::onDrawerSlide(OnDrawerSlide $event) const {
  dispatchEvent("drawerSlide", [$event=std::move($event)](jsi::Runtime &runtime) {
    auto $payload = jsi::Object(runtime);
    $payload.setProperty(runtime, "offset", $event.offset);
    return $payload;
  });
}


void AndroidDrawerLayoutEventEmitter::onDrawerStateChanged(OnDrawerStateChanged $event) const {
  dispatchEvent("drawerStateChanged", [$event=std::move($event)](jsi::Runtime &runtime) {
    auto $payload = jsi::Object(runtime);
    $payload.setProperty(runtime, "drawerState", $event.drawerState);
    return $payload;
  });
}


void AndroidDrawerLayoutEventEmitter::onDrawerOpen(OnDrawerOpen $event) const {
  dispatchEvent("drawerOpen", [](jsi::Runtime &runtime) {
    auto $payload = jsi::Object(runtime);
    
    return $payload;
  });
}


void AndroidDrawerLayoutEventEmitter::onDrawerClose(OnDrawerClose $event) const {
  dispatchEvent("drawerClose", [](jsi::Runtime &runtime) {
    auto $payload = jsi::Object(runtime);
    
    return $payload;
  });
}



void AndroidSwipeRefreshLayoutEventEmitter::onRefresh(OnRefresh $event) const {
  dispatchEvent("refresh", [](jsi::Runtime &runtime) {
    auto $payload = jsi::Object(runtime);
    
    return $payload;
  });
}


void AndroidSwitchEventEmitter::onChange(OnChange $event) const {
  dispatchEvent("change", [$event=std::move($event)](jsi::Runtime &runtime) {
    auto $payload = jsi::Object(runtime);
    $payload.setProperty(runtime, "value", $event.value);
$payload.setProperty(runtime, "target", $event.target);
    return $payload;
  });
}




void PullToRefreshViewEventEmitter::onRefresh(OnRefresh $event) const {
  dispatchEvent("refresh", [](jsi::Runtime &runtime) {
    auto $payload = jsi::Object(runtime);
    
    return $payload;
  });
}



void ModalHostViewEventEmitter::onRequestClose(OnRequestClose $event) const {
  dispatchEvent("requestClose", [](jsi::Runtime &runtime) {
    auto $payload = jsi::Object(runtime);
    
    return $payload;
  });
}


void ModalHostViewEventEmitter::onShow(OnShow $event) const {
  dispatchEvent("show", [](jsi::Runtime &runtime) {
    auto $payload = jsi::Object(runtime);
    
    return $payload;
  });
}


void ModalHostViewEventEmitter::onDismiss(OnDismiss $event) const {
  dispatchEvent("dismiss", [](jsi::Runtime &runtime) {
    auto $payload = jsi::Object(runtime);
    
    return $payload;
  });
}


void ModalHostViewEventEmitter::onOrientationChange(OnOrientationChange $event) const {
  dispatchEvent("orientationChange", [$event=std::move($event)](jsi::Runtime &runtime) {
    auto $payload = jsi::Object(runtime);
    $payload.setProperty(runtime, "orientation", toString($event.orientation));
    return $payload;
  });
}



void SwitchEventEmitter::onChange(OnChange $event) const {
  dispatchEvent("change", [$event=std::move($event)](jsi::Runtime &runtime) {
    auto $payload = jsi::Object(runtime);
    $payload.setProperty(runtime, "value", $event.value);
$payload.setProperty(runtime, "target", $event.target);
    return $payload;
  });
}


} // namespace facebook::react