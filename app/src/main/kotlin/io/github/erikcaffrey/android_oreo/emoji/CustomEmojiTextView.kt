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

import android.content.Context
import android.support.text.emoji.widget.EmojiTextViewHelper
import android.support.v7.widget.AppCompatTextView
import android.text.InputFilter
import android.util.AttributeSet

class CustomEmojiTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                                    defStyleAttr: Int = 0)
    : AppCompatTextView(context, attrs, defStyleAttr) {

    private var emojiTextViewHelperInstance: EmojiTextViewHelper? = null

    private val emojiTextViewHelper: EmojiTextViewHelper
        get() {
            if (emojiTextViewHelperInstance == null) {
                emojiTextViewHelperInstance = EmojiTextViewHelper(this)
            }
            return emojiTextViewHelperInstance as EmojiTextViewHelper
        }

    init {
        emojiTextViewHelper.updateTransformationMethod()
    }

    override fun setFilters(filters: Array<InputFilter>) {
        super.setFilters(emojiTextViewHelper.getFilters(filters))
    }

    override fun setAllCaps(allCaps: Boolean) {
        super.setAllCaps(allCaps)
        emojiTextViewHelper.setAllCaps(allCaps)
    }

}
