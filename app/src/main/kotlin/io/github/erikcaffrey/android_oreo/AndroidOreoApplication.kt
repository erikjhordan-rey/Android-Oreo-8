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