package com.firriezky.dicoding._5_ListView.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.firriezky.dicoding.R
import com.firriezky.dicoding._5_ListView.Hero
import com.firriezky.dicoding.databinding.ItemHeroBinding

class HeroAdapter(val context : Context) : BaseAdapter(){
    var heroes = arrayListOf<Hero>()
    lateinit var heroInterface: HeroInterface

    fun setOnClickInterface(heroInterface: HeroInterface){
        this.heroInterface = heroInterface
    }

    override fun getCount(): Int = heroes.size
    override fun getItem(position: Int): Any = heroes[position]
    override fun getItemId(position: Int): Long  = position.toLong()


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero,parent,false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return  itemView
    }

    inner class ViewHolder(view: View){
        private val txtName = view.findViewById(R.id.tv_item_name) as TextView
        private val txtDetail = view.findViewById(R.id.tv_item_detail) as TextView
        private val imgPhoto = view.findViewById(R.id.img_item_photo) as ImageView
        var viewBinding  =  ItemHeroBinding.bind(view)

        fun bind(hero: Hero){
            txtName.text=hero.name
            txtDetail.text=hero.description
            imgPhoto.setImageResource(hero.photo)

            viewBinding.root.setOnClickListener {
                heroInterface.onClick(hero)
            }

        }
    }

    interface HeroInterface{
        fun onClick(hero:Hero);
    }


}