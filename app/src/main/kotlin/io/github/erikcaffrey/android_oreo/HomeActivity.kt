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

import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener
import android.support.v4.app.Fragment
import android.view.MenuItem
import erikjhordanrey.base_components.view.BaseActivity
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

    private fun initHomeUi() {
        show(FontsFragment())
        navigation.setOnNavigationItemSelectedListener(this)
    }

    private fun show(fragment: Fragment?) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

    private fun getFragment(itemId: Int): Fragment? {
        var fragment: Fragment? = null
        when (itemId) {
            R.id.navigation_fonts -> {
                fragment = FontsFragment()
            }
            R.id.navigation_emoji -> {
                fragment = EmojiFragment()
            }
            R.id.navigation_autosizing -> {
                fragment = AutosizingFragment()
            }
        }
        return fragment
    }
}
