package com.firriezky.dicoding._3_recyclerview.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.firriezky.dicoding.databinding.ItemHeroBinding

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    lateinit var heroDatas : ArrayList<Hero>
    lateinit var binding : ItemHeroBinding

    fun setHeroData(importData : ArrayList<Hero>){
        heroDatas=importData
    }

    inner class HeroViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        binding = ItemHeroBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HeroViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return heroDatas.size
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {

        heroDatas[position].let { raz ->
            binding.tvItemName.text=raz.name
            binding.tvItemDetail.text=raz.detail
            Glide.with(binding.root.context)
                .load(raz.photo)
                .apply(RequestOptions().override(55,59))
                .into(binding.imgItemPhoto)
        }
    }

}