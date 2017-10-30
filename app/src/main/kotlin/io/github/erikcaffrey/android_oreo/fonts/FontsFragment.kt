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
package io.github.erikcaffrey.android_oreo.fonts

import android.graphics.Typeface
import android.os.Handler
import android.os.HandlerThread
import android.support.v4.provider.FontRequest
import android.support.v4.provider.FontsContractCompat
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import erikjhordanrey.base_components.view.BaseFragment
import io.github.erikcaffrey.android_oreo.R
import io.github.erikcaffrey.android_oreo.common.Constants
import kotlinx.android.synthetic.main.fragment_fonts.*

class FontsFragment : BaseFragment() {

  override fun getLayoutResId() = R.layout.fragment_fonts

  override fun initFragment(view: View) {
    super.initFragment(view)

    val familyAdapter = getFamilyAdapter()
    spinner_fonts.adapter = familyAdapter

    button_download.setOnClickListener {
      requestDownloadableFont()
    }

  }

  private fun getFamilyAdapter() =
      ArrayAdapter(activity, android.R.layout.simple_dropdown_item_1line, resources.getStringArray(R.array.family_names))

  private fun requestDownloadableFont() {
    val query = spinner_fonts.selectedItem.toString()
    val fontRequest = getFontRequest(query)
    val fontRequestCallback = getFontRequestCallback()
    FontsContractCompat.requestFont(context!!, fontRequest, fontRequestCallback, getHandler())
  }

  private fun getFontRequestCallback() = object : FontsContractCompat.FontRequestCallback() {

    override fun onTypefaceRetrieved(typeface: Typeface?) {
      super.onTypefaceRetrieved(typeface)
      text_font_disclaimer.typeface = typeface
    }

    override fun onTypefaceRequestFailed(reason: Int) {
      super.onTypefaceRequestFailed(reason)
      Log.e(FontsFragment::class.java.simpleName, "An Error Occurred: " + reason)
    }

  }

  private fun getFontRequest(query: String) = FontRequest(
      Constants.PROVIDER_AUTHORITY,
      Constants.PROVIDER_PACKAGE,
      query,
      R.array.com_google_android_gms_fonts_certs)

  private fun getHandler(): Handler {
    val handlerThread = HandlerThread("fonts")
    handlerThread.start()
    return Handler(handlerThread.looper)
  }

}
