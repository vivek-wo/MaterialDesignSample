package com.vivek.wo.md.sample.appbar

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginRight
import com.google.android.material.appbar.AppBarLayout
import com.vivek.wo.md.sample.R
import kotlinx.android.synthetic.main.ab_tab_activity_main.*

class CollapsingTabLayoutActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener {
    var tabLayoutWidth = 0
    var tabLayoutHeight = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ab_tab_activity_main)
        initTab()
    }

    override fun onResume() {
        super.onResume()
        appbarLayout.addOnOffsetChangedListener(this)
    }

    override fun onPause() {
        super.onPause()
        appbarLayout.removeOnOffsetChangedListener(this)
    }

    private fun initTab() {
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"))
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"))
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"))
        tabLayout.addTab(tabLayout.newTab().setText("Tab 4"))
    }

    var oldOffset = 0

    override fun onOffsetChanged(p0: AppBarLayout?, p1: Int) {
        if (oldOffset != p1) {
            oldOffset = p1;
            if (tabLayoutWidth == 0) {
                tabLayoutWidth = tabLayout.width
                tabLayoutHeight = tabLayout.height
            }
            Log.w("---------", ": $p1 ${appbarLayout.totalScrollRange}")
            var offset = -p1 / appbarLayout.totalScrollRange.toFloat()
            var alpha = offset
            editSearch.alpha = 1.0f - alpha
            searchButton.alpha = alpha
            var lp = tabLayout.layoutParams
            lp.width =
                tabLayoutWidth - (offset * (searchButton.width + searchButton.marginRight)).toInt()
            lp.height = tabLayoutHeight - ((tabLayoutHeight - toolbar.height) * offset).toInt()
            Log.w("---------", "-----$tabLayoutWidth,$tabLayoutHeight,${lp.width} ${lp.height}")
            tabLayout.layoutParams = lp
        }
    }
}