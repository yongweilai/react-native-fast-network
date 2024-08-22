
/**
 * This code was generated by [react-native-codegen](https://www.npmjs.com/package/react-native-codegen).
 *
 * Do not edit this file as changes may cause incorrect behavior and will be lost
 * once the code is regenerated.
 *
 * @generated by codegen project: GenerateModuleJavaSpec.js
 *
 * @nolint
 */

package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

public abstract class NativeAnimatedModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
  public static final String NAME = "NativeAnimatedModule";

  public NativeAnimatedModuleSpec(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public @Nonnull String getName() {
    return NAME;
  }

  @ReactMethod
  @DoNotStrip
  public abstract void startOperationBatch();

  @ReactMethod
  @DoNotStrip
  public abstract void finishOperationBatch();

  @ReactMethod
  @DoNotStrip
  public abstract void createAnimatedNode(double tag, ReadableMap config);

  @ReactMethod
  @DoNotStrip
  public void updateAnimatedNodeConfig(double tag, ReadableMap config) {}

  @ReactMethod
  @DoNotStrip
  public abstract void getValue(double tag, Callback saveValueCallback);

  @ReactMethod
  @DoNotStrip
  public abstract void startListeningToAnimatedNodeValue(double tag);

  @ReactMethod
  @DoNotStrip
  public abstract void stopListeningToAnimatedNodeValue(double tag);

  @ReactMethod
  @DoNotStrip
  public abstract void connectAnimatedNodes(double parentTag, double childTag);

  @ReactMethod
  @DoNotStrip
  public abstract void disconnectAnimatedNodes(double parentTag, double childTag);

  @ReactMethod
  @DoNotStrip
  public abstract void startAnimatingNode(double animationId, double nodeTag, ReadableMap config, Callback endCallback);

  @ReactMethod
  @DoNotStrip
  public abstract void stopAnimation(double animationId);

  @ReactMethod
  @DoNotStrip
  public abstract void setAnimatedNodeValue(double nodeTag, double value);

  @ReactMethod
  @DoNotStrip
  public abstract void setAnimatedNodeOffset(double nodeTag, double offset);

  @ReactMethod
  @DoNotStrip
  public abstract void flattenAnimatedNodeOffset(double nodeTag);

  @ReactMethod
  @DoNotStrip
  public abstract void extractAnimatedNodeOffset(double nodeTag);

  @ReactMethod
  @DoNotStrip
  public abstract void connectAnimatedNodeToView(double nodeTag, double viewTag);

  @ReactMethod
  @DoNotStrip
  public abstract void disconnectAnimatedNodeFromView(double nodeTag, double viewTag);

  @ReactMethod
  @DoNotStrip
  public abstract void restoreDefaultValues(double nodeTag);

  @ReactMethod
  @DoNotStrip
  public abstract void dropAnimatedNode(double tag);

  @ReactMethod
  @DoNotStrip
  public abstract void addAnimatedEventToView(double viewTag, String eventName, ReadableMap eventMapping);

  @ReactMethod
  @DoNotStrip
  public abstract void removeAnimatedEventFromView(double viewTag, String eventName, double animatedNodeTag);

  @ReactMethod
  @DoNotStrip
  public abstract void addListener(String eventName);

  @ReactMethod
  @DoNotStrip
  public abstract void removeListeners(double count);

  @ReactMethod
  @DoNotStrip
  public void queueAndExecuteBatchedOperations(ReadableArray operationsAndArgs) {}
}
