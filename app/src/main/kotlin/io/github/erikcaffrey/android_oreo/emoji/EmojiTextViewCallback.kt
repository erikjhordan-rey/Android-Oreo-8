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
package io.github.erikcaffrey.android_oreo.emoji

import android.support.text.emoji.EmojiCompat
import android.widget.TextView
import java.lang.ref.WeakReference

class EmojiTextViewCallback constructor(regularTextView: TextView, val text: String) : EmojiCompat.InitCallback() {

    private val regularTextViewReference: WeakReference<TextView> = WeakReference(regularTextView)

    override fun onInitialized() {
        super.onInitialized()
        val regularTextView = regularTextViewReference.get()
        regularTextView!!.text = EmojiCompat.get().process(text)
    }

    override fun onFailed(throwable: Throwable?) {
        super.onFailed(throwable)
        throwable!!.printStackTrace()
    }
}