package com.feylabs.navigationdrawer.ui.tablayout2

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.feylabs.navigationdrawer.R

class TabLayout2 : Fragment() {

    companion object {
        fun newInstance() = TabLayout2()
    }

    private lateinit var viewModel: TabLayout2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tab_layout2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TabLayout2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}