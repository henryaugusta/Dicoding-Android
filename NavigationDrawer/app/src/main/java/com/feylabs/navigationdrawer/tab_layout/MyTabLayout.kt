package com.feylabs.navigationdrawer.tab_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.feylabs.navigationdrawer.R
import com.feylabs.navigationdrawer.databinding.ActivityMyTabLayoutBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MyTabLayout : AppCompatActivity() {

    lateinit var viewBinding : ActivityMyTabLayoutBinding

    companion object {
        private val TAB_TITLES = arrayOf(
            "TB 1",
            "TB 2"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMyTabLayoutBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val sectionPagerAdapter= SectionPagerAdapter(this);
        val viewPager = viewBinding.viewPager as ViewPager2

        viewPager.adapter=sectionPagerAdapter
        val tabs = viewBinding.tabs as TabLayout

        TabLayoutMediator(tabs,viewPager){ tab, position ->
            tab.text = TAB_TITLES[position]
        }.attach()

        supportActionBar?.elevation = 0f

    }
}