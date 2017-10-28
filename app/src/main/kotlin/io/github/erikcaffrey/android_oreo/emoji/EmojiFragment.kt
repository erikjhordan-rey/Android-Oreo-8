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
import android.view.View
import erikjhordanrey.base_components.view.BaseFragment
import io.github.erikcaffrey.android_oreo.R
import kotlinx.android.synthetic.main.fragment_emoji.*

class EmojiFragment : BaseFragment() {

    companion object {
        private const val AVOCADO_EMOJI = "\ud83e\udd51"
        private const val WINK_EMOJI = "\uD83D\uDE09"
        private const val FLAG_EMOJI = "\uD83C\uDDF2\uD83C\uDDFD"
        private const val MONKEYS_EMOJI = "\uD83D\uDE4A" + " " + "\uD83D\uDE48" + "\uD83D\uDE49"
        private const val HEART_EYES_EMOJI = "\uD83D\uDE0D"
    }

    override fun getLayoutResId() = R.layout.fragment_emoji

    override fun initFragment(view: View) {
        super.initFragment(view)
        text_emoji.text = getString(R.string.emoji_text_view_text, AVOCADO_EMOJI)
        edit_emoji.setText(getString(R.string.emoji_edit_text_text, WINK_EMOJI))
        button_emoji.text = getString(R.string.emoji_button_text, FLAG_EMOJI)
        val emojiTextViewCallback = EmojiTextViewCallback(text_emoji_regular, getString(R.string.emoji_regular_text, MONKEYS_EMOJI))
        EmojiCompat.get().registerInitCallback(emojiTextViewCallback)
        text_emoji_custom.text = getString(R.string.emoji_custom_text, HEART_EYES_EMOJI)
    }
}