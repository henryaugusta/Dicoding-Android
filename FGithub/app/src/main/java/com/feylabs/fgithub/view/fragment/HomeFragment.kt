package com.feylabs.fgithub.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.feylabs.fgithub.R
import com.feylabs.fgithub.adapter.SearchAdapter
import com.feylabs.fgithub.databinding.FragmentHomeBinding
import com.feylabs.fgithub.model.SearchResult
import com.feylabs.fgithub.util.BaseFragment
import com.feylabs.fgithub.view.activity.DetailUserActivity
import com.feylabs.fgithub.viewmodel.UserViewModel
import www.sanju.motiontoast.MotionToast


class HomeFragment : BaseFragment() {
    lateinit var vbind: FragmentHomeBinding
    lateinit var searchViewModel: UserViewModel

    lateinit var searchAdapter: SearchAdapter

    companion object{
        const val USER = "user_id"
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_home, container, false)
        vbind = FragmentHomeBinding.bind(view)
        // Inflate the layout for this fragment
        return vbind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        setRecyclerView()
        vbind.labelPlaceholder.setText(getString(R.string.search_github_users_that_might_inspired_you))

        val adapter = SearchAdapter()
        adapter.setInterface(object : SearchAdapter.SearchAdapterInterface {
            override fun onclick(model: SearchResult) {
                val intent = Intent(requireActivity(),
                    DetailUserActivity::class.java)
                intent.putExtra(USER,model)
                startActivity(intent)
            }
        })

        vbind.recyclerViewSearchResult.adapter = adapter


        vbind.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query.toString().showLongToast()
                showLoading(true)
                vbind.labelPlaceholder.visibility = View.GONE
                searchViewModel.searchUser(query.toString())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.toString().isEmpty()) {
                    vbind.labelPlaceholder.visibility = View.VISIBLE
                    adapter.clearData()
                    adapter.notifyDataSetChanged()
                } else {
                    vbind.labelPlaceholder.visibility = View.GONE
                }

                return false
            }

        })

        searchViewModel.searchResultQuery.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.setData(it)
                adapter.notifyDataSetChanged()
                showLoading(false)
                showMotionToast(
                    getString(R.string.success),
                    getString(R.string.success_retrieve_user),
                    MotionToast.TOAST_SUCCESS
                )
            } else {
                showLoading(false)
                showMotionToast(
                    getString(R.string.not_found404),
                    getString(R.string.user_not_found),
                    MotionToast.TOAST_ERROR
                )
            }

        })

    }

    private fun setRecyclerView() {
        vbind.recyclerViewSearchResult.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
        }
    }


    private fun showLoading(state: Boolean) {
        if (state) {
            vbind.progressBar.visibility = View.VISIBLE
        } else {
            vbind.progressBar.visibility = View.GONE
        }
    }


}