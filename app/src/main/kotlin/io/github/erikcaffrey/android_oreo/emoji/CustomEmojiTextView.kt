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
