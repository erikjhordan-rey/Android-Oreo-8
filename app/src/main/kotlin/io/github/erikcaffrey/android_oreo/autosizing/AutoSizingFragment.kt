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
package io.github.erikcaffrey.android_oreo.autosizing

import android.support.constraint.ConstraintLayout
import android.util.DisplayMetrics
import android.view.View
import android.widget.SeekBar
import erikjhordanrey.base_components.view.BaseFragment
import io.github.erikcaffrey.android_oreo.R
import kotlinx.android.synthetic.main.fragment_autosizing.*

class AutoSizingFragment : BaseFragment() {

    override fun getLayoutResId() = R.layout.fragment_autosizing

    override fun initFragment(view: View) {
        super.initFragment(view)
        // I have created AutoSizingExt.kt to facilitate & manage Autosizing TextViews programmatically
        initUiAutoSizing()
    }

    private fun initUiAutoSizing() {
        seek_bar_scale_x.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                scaleView(text_default, i)
                scaleView(text_granularity, i)
                scaleView(text_preset_sizes, i)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

        seek_bar_scale_y.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                scaleView(text_default, i, Orientation.VERTICAL)
                scaleView(text_granularity, i, Orientation.VERTICAL)
                scaleView(text_preset_sizes, i, Orientation.VERTICAL)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })
    }

    private fun scaleView(view: View, margin: Int, orientation: Orientation = Orientation.HORIZONTAL) {
        val params = view.layoutParams as ConstraintLayout.LayoutParams
        val marginPx = transformDpToPixel(margin.toFloat())
        when (orientation) {
            Orientation.HORIZONTAL -> {
                params.rightMargin = marginPx
                params.leftMargin = marginPx
            }
            else -> {
                params.height = marginPx
            }
        }

        view.layoutParams = params
    }

    private fun transformDpToPixel(dp: Float): Int {
        val metrics = resources.displayMetrics
        return (dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
    }

}