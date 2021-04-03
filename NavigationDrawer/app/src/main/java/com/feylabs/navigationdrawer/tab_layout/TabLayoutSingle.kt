package com.feylabs.navigationdrawer.tab_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.feylabs.navigationdrawer.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutSingle : AppCompatActivity() {

    companion object {
        val TAB_TITLES = arrayOf(
            "MENU 1",
            "MENU 2",
            "MENU 3",
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout_single_fragment)

        val sectionAdapter = SectionPagerAdapterSingle(this)

        val vp = findViewById(R.id.view_pager) as ViewPager2
        val tl = findViewById(R.id.tabs) as TabLayout

        vp.adapter=sectionAdapter


        TabLayoutMediator(tl, vp) { tab, position ->
            tab.text = TAB_TITLES[position]
        }.attach()

    }
}