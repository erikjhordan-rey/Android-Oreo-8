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
package io.github.erikcaffrey.android_oreo.home

import android.app.PictureInPictureParams
import android.content.res.Configuration
import android.os.Build
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener
import android.support.v4.app.Fragment
import android.util.Rational
import android.view.Menu
import android.view.MenuItem
import erikjhordanrey.base_components.view.BaseActivity
import io.github.erikcaffrey.android_oreo.R
import io.github.erikcaffrey.android_oreo.autosizing.AutoSizingFragment
import io.github.erikcaffrey.android_oreo.emoji.EmojiFragment
import io.github.erikcaffrey.android_oreo.fonts.FontsFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(), OnNavigationItemSelectedListener {

    override fun getLayoutResId() = R.layout.activity_home

    override fun initActivity() {
        super.initActivity()
        initHomeUi()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragment: Fragment? = getFragment(item.itemId)
        show(fragment)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_pip) {
            setPictureInPicture()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPictureInPictureModeChanged(isInPictureInPictureMode: Boolean, newConfig: Configuration?) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)
        if (isInPictureInPictureMode) {
            println("Picture-in-picture mode")
        } else {
            println("Restore the full-screen UI")
        }
    }

    private fun initHomeUi() {
        show(FontsFragment())
        navigation.setOnNavigationItemSelectedListener(this)
    }

    private fun show(fragment: Fragment?) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

    private fun getFragment(itemId: Int): Fragment? = when (itemId) {
        R.id.navigation_fonts -> FontsFragment()
        R.id.navigation_emoji -> EmojiFragment()
        R.id.navigation_autosizing -> AutoSizingFragment()
        else -> null
    }

    private fun setPictureInPicture() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val pictureInPictureParamsBuilder = PictureInPictureParams.Builder()
            val aspectRatio = Rational(1200, 600)
            pictureInPictureParamsBuilder.setAspectRatio(aspectRatio).build()
            enterPictureInPictureMode(pictureInPictureParamsBuilder.build())
        }
    }
}

