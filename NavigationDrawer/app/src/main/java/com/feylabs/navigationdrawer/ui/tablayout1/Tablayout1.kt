package com.feylabs.navigationdrawer.ui.tablayout1

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.feylabs.navigationdrawer.R

class Tablayout1 : Fragment() {

    companion object {
        fun newInstance() =
            Tablayout1()
    }

    private lateinit var viewModel: Tablayout1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tablayout1_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Tablayout1ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}