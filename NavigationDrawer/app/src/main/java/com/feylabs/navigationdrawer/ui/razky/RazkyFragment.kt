package com.feylabs.navigationdrawer.ui.razky

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.feylabs.navigationdrawer.R
import com.feylabs.navigationdrawer.databinding.FragmentRazkyBinding


class RazkyFragment : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var  razkyViewModel: RazkyViewModel
    lateinit var viewBinding : FragmentRazkyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        razkyViewModel = ViewModelProvider(this).get(RazkyViewModel::class.java)
        razkyViewModel.text.value

        viewBinding = FragmentRazkyBinding.inflate(inflater,container,false)
        val view = viewBinding.root

        razkyViewModel.text.observe(viewLifecycleOwner, Observer {
            viewBinding.textRaz.text=it
        })

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.pushMe.setOnClickListener {
            razkyViewModel.setUserName("HEHEHEHE")
        }

    }

}