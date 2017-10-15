package io.github.erikcaffrey.android_oreo

import android.app.Application
import android.graphics.Color
import android.support.text.emoji.EmojiCompat
import android.support.text.emoji.FontRequestEmojiCompatConfig
import android.support.text.emoji.bundled.BundledEmojiCompatConfig
import android.support.v4.provider.FontRequest
import io.github.erikcaffrey.android_oreo.common.Constants


class AndroidOreoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val config: EmojiCompat.Config

        if (Constants.ENABLE_BUNDLED_EMOJI) {
            config = BundledEmojiCompatConfig(applicationContext)
        } else {

            val fontRequest = FontRequest(
                    Constants.PROVIDER_AUTHORITY,
                    Constants.PROVIDER_PACKAGE,
                    Constants.FONT_QUERY,
                    R.array.com_google_android_gms_fonts_certs)

            config = FontRequestEmojiCompatConfig(this, fontRequest)
                    .setReplaceAll(true)
                    .setEmojiSpanIndicatorEnabled(false)
                    .setEmojiSpanIndicatorColor(Color.MAGENTA)
        }

        EmojiCompat.init(config)
    }
}