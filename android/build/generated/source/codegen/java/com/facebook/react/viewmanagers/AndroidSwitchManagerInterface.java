/**
* This code was generated by [react-native-codegen](https://www.npmjs.com/package/react-native-codegen).
*
* Do not edit this file as changes may cause incorrect behavior and will be lost
* once the code is regenerated.
*
* @generated by codegen project: GeneratePropsJavaInterface.js
*/

package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;

public interface AndroidSwitchManagerInterface<T extends View> {
  void setDisabled(T view, boolean value);
  void setEnabled(T view, boolean value);
  void setThumbColor(T view, @Nullable Integer value);
  void setTrackColorForFalse(T view, @Nullable Integer value);
  void setTrackColorForTrue(T view, @Nullable Integer value);
  void setValue(T view, boolean value);
  void setOn(T view, boolean value);
  void setThumbTintColor(T view, @Nullable Integer value);
  void setTrackTintColor(T view, @Nullable Integer value);
  void setNativeValue(T view, boolean value);
}
