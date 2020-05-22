package com.vivek.wo.md.sample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.vivek.wo.md.sample.appbar.AppBarMainActivity
import com.vivek.wo.md.sample.appbar.CollapsingTabLayoutActivity
import com.vivek.wo.md.sample.bottomnavigation.BottonNavigationMainActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun intentBottomNavigation(view: View) {
        startActivity(Intent(this, BottonNavigationMainActivity::class.java))
    }

    fun intentAppBar(view: View) {
        startActivity(Intent(this, AppBarMainActivity::class.java))
    }

    fun intentAppBarTabLayout(view: View) {
        startActivity(Intent(this, CollapsingTabLayoutActivity::class.java))
    }
}