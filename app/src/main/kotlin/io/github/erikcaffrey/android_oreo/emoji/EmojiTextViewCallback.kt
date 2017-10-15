package io.github.erikcaffrey.android_oreo.emoji

import android.support.text.emoji.EmojiCompat
import android.widget.TextView
import java.lang.ref.WeakReference


class EmojiTextViewCallback constructor(regularTextView: TextView, val text: String) : EmojiCompat.InitCallback() {

    val regularTextViewReference: WeakReference<TextView> = WeakReference(regularTextView)

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