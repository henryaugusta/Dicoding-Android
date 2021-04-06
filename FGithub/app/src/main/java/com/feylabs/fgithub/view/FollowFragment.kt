package com.feylabs.fgithub.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.feylabs.fgithub.R
import com.feylabs.fgithub.util.BaseFragment
import com.feylabs.fgithub.viewmodel.DetailViewModel
import com.feylabs.fgithub.viewmodel.UserViewModel


class FollowFragment : BaseFragment() {

    lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arg = arguments?.get(DetailUserActivity.URL).toString()
        arg.showLongToast()

        userViewModel= ViewModelProvider(requireActivity(),ViewModelProvider.NewInstanceFactory())
            .get(UserViewModel::class.java)

    }


}