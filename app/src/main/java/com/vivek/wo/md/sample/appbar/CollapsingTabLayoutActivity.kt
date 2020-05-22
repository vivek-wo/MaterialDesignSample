package com.vivek.wo.md.sample.appbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vivek.wo.md.sample.R
import kotlinx.android.synthetic.main.ab_tab_activity_main.*

class CollapsingTabLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ab_tab_activity_main)
        initTab()
    }

    private fun initTab() {
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"))
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"))
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"))
        tabLayout.addTab(tabLayout.newTab().setText("Tab 4"))
    }
}