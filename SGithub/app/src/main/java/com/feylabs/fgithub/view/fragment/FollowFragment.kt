package com.feylabs.fgithub.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.feylabs.fgithub.R
import com.feylabs.fgithub.adapter.SearchAdapter
import com.feylabs.fgithub.databinding.FragmentDetailBinding
import com.feylabs.fgithub.model.SearchResult
import com.feylabs.fgithub.util.BaseFragment
import com.feylabs.fgithub.view.activity.DetailUserActivity
import com.feylabs.fgithub.viewmodel.FollowViewModel


class FollowFragment : BaseFragment() {

    lateinit var userViewModel: FollowViewModel
    lateinit var userAdapter: SearchAdapter
    lateinit var vbinding: FragmentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FragmentDetailBinding.inflate(LayoutInflater.from(context), container, false)
        vbinding = view
        // Inflate the layout for this fragment
        return view.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setAdapter()
        setRecyclerView()
        setUserViewModel()

        //get arg from bundle
        // and Check if there is argument on bundle
        val arg = arguments?.get(DetailUserActivity.URL).toString()
        if (!arg.isBlank() || arg == "") {
            userViewModel.getFollowData(arg)
        }





    }

    private fun setAdapter() {
        userAdapter = SearchAdapter()
        userAdapter.setInterface(object : SearchAdapter.SearchAdapterInterface {
            override fun onclick(model: SearchResult) {
                val intent = Intent(requireActivity(), DetailUserActivity::class.java)
                intent.putExtra(HomeFragment.USER, model)
                startActivity(intent)
            }

        })
    }

    private fun setUserViewModel() {
        userViewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())
            .get(FollowViewModel::class.java)

        userViewModel.followData.observe(requireActivity(), Observer {
            userAdapter.setData(it)
            if (it != null) {
                vbinding.apply {
                    userAdapter.setData(it)
                    recyclerViewSearchResult.adapter = userAdapter
                    progressBar.visibility = View.GONE
                    userAdapter.notifyDataSetChanged()

                }
            } else {
                getString(R.string.no_data).showLongToast()
                vbinding.progressBar.visibility = View.GONE
            }
        })
    }

    private fun setRecyclerView() {
        vbinding.recyclerViewSearchResult.setHasFixedSize(true)
        vbinding.recyclerViewSearchResult.layoutManager = LinearLayoutManager(requireContext())
    }


}