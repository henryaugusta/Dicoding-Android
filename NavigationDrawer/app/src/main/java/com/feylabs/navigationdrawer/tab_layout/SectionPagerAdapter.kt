package com.feylabs.navigationdrawer.tab_layout

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.feylabs.navigationdrawer.ui.tablayout1.Tablayout1
import com.feylabs.navigationdrawer.ui.tablayout2.TabLayout2

class SectionPagerAdapter (activity : AppCompatActivity) : FragmentStateAdapter(activity){

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment : Fragment? = null;
        when(position){
            0 -> fragment = Tablayout1()
            1-> fragment = TabLayout2()
        }

        return fragment as Fragment
    }

}