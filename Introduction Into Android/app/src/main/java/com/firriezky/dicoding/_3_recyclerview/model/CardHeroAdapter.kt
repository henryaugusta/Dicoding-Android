package com.firriezky.dicoding._3_recyclerview.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.firriezky.dicoding.databinding.ItemCardHeroBinding
import com.firriezky.dicoding.databinding.ItemGridHeroBinding
import com.firriezky.dicoding.databinding.ItemHeroBinding

class CardHeroAdapter : RecyclerView.Adapter<CardHeroAdapter.HeroViewHolder>() {

    lateinit var heroDatas : ArrayList<Hero>
    lateinit var binding : ItemCardHeroBinding


    fun setHeroData(importData : ArrayList<Hero>){
        heroDatas=importData

    }

    inner class HeroViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        binding = ItemCardHeroBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HeroViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return heroDatas.size
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.itemView.setOnClickListener{

        }

        heroDatas[position].let { raz ->
            binding.tvItemName.text=raz.name
            binding.tvItemDetail.text=raz.detail
            Glide.with(binding.root.context)
                .load(raz.photo)
                .apply(RequestOptions().override(350, 550))
                .into(binding.imgItemPhoto)
        }
    }

    interface Clicker{
        fun onClicked(data:Hero)
    }

}