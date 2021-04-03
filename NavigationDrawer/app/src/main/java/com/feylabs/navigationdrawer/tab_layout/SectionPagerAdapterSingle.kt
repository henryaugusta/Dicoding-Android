package com.feylabs.navigationdrawer.tab_layout

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.feylabs.navigationdrawer.ui.tablayoutsingle.TabLayoutSingle
import com.feylabs.navigationdrawer.ui.tablayoutsingle.TabLayoutSingle.Companion.newInstance

class SectionPagerAdapterSingle (activity:AppCompatActivity) : FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return TabLayoutSingle.newInstance(position+1)
    }

}