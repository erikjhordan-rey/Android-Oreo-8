/*
 * Copyright 2017 Erik Jhordan Rey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.erikcaffrey.android_oreo.autosizing

import android.support.v4.widget.TextViewCompat
import android.support.v7.widget.AppCompatTextView
import android.util.TypedValue
import android.widget.TextView

/*
 * This class is an extension to facilitate the use of AutoSizing on AppCompatTextView.
 */

// Default

// Dimensions for uniform scaling are minTextSize = 12sp, maxTextSize = 112sp, and granularity = 1px.

fun AppCompatTextView.setAutoSizeTextTypeWithDefault(autoSizeTextType: Int) {
    TextViewCompat.setAutoSizeTextTypeWithDefaults(this, autoSizeTextType)
}

fun AppCompatTextView.setAutoSizeTextDefaultUniform() {
    TextViewCompat.setAutoSizeTextTypeWithDefaults(this, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
}

fun AppCompatTextView.setAutoSizeTextDefaultNone() {
    TextViewCompat.setAutoSizeTextTypeWithDefaults(this, TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE)
}

// Granularity

fun AppCompatTextView.setAutoSizeTextGranularity(autoSizeMinTextSize: Int, autoSizeMaxTextSize: Int, autoSizeStepGranularity: Int, unit: Int) {
    TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(this, autoSizeMinTextSize, autoSizeMaxTextSize, autoSizeStepGranularity, unit)
}

fun AppCompatTextView.setAutoSizeTextDefaultGranularity(autoSizeMinTextSize: Int, autoSizeMaxTextSize: Int) {
    val autoSizeStepGranularity = 2
    TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(this, autoSizeMinTextSize, autoSizeMaxTextSize, autoSizeStepGranularity, TypedValue.COMPLEX_UNIT_SP)
}

fun AppCompatTextView.setAutoSizeTextGranularitySp(autoSizeMinTextSize: Int, autoSizeMaxTextSize: Int, autoSizeStepGranularity: Int) {
    TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(this, autoSizeMinTextSize, autoSizeMaxTextSize, autoSizeStepGranularity, TypedValue.COMPLEX_UNIT_SP)
}

// Preset sizes

fun AppCompatTextView.setAutoSizeTextPresetSizes(autoSizeTextSizes: IntArray) {
    TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(this, autoSizeTextSizes, TypedValue.COMPLEX_UNIT_SP)
}

fun AppCompatTextView.setAutoSizeTextPresetSizes(autoSizeTextSizes: IntArray, unit: Int) {
    TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(this, autoSizeTextSizes, unit)
}

fun AppCompatTextView.setAutoSizeTextDefaultPresetSizes(textView: TextView) {
    val autoSizeTextSizes = intArrayOf(10, 12, 16, 20, 40, 100)
    TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(textView, autoSizeTextSizes, TypedValue.COMPLEX_UNIT_SP)
}