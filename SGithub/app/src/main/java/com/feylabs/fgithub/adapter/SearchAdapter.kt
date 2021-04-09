package com.feylabs.fgithub.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.feylabs.fgithub.R
import com.feylabs.fgithub.databinding.ListUserBinding
import com.feylabs.fgithub.model.SearchResult
import com.feylabs.fgithub.viewmodel.UserViewModel
import com.squareup.picasso.Picasso

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
    var searchResultData = mutableListOf<SearchResult>()
    lateinit var searchInterface : SearchAdapterInterface

    fun setData(data : MutableList<SearchResult>){
        searchResultData.clear()
        searchResultData.addAll(data)
    }

    fun clearData(){
        searchResultData.clear()
    }

    fun setInterface(interfaceSet : SearchAdapterInterface){
        searchInterface=interfaceSet
    }

    inner class SearchViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val vbinding = ListUserBinding.bind(v)
        fun setData(model : SearchResult){
            val name = model.name.toString()


            vbinding.userUsername.text = model.username

            vbinding.btnUserDetail.setOnClickListener {
                searchInterface.onclick(model)
            }
            Picasso.get()
                .load(model.photo)
                .into(vbinding.profileImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_user,parent,false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return searchResultData.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.setData(searchResultData[position])
    }

    interface SearchAdapterInterface{
        fun onclick(model: SearchResult)
    }

}