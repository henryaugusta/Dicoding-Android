package com.firriezky.dicoding._5_ListView

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.firriezky.dicoding.R
import com.firriezky.dicoding._5_ListView.Adapter.HeroAdapter
import com.firriezky.dicoding.databinding.ActivityListViewMainBinding

class ListViewMainActivity : AppCompatActivity() {

    lateinit var binding : ActivityListViewMainBinding

//    val dataName = arrayListOf("Razky","Henry","Syakir","Ahmad")

    private lateinit var adapter : HeroAdapter
    private lateinit var dataName : Array<String>
    private lateinit var dataDetail : Array<String>
    private lateinit var dataPhoto : TypedArray

    private var dataHeroes = arrayListOf<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepare()

//        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataName)
       adapter = HeroAdapter(this)
        binding.lvList.adapter=adapter

        adapter.heroes=dataHeroes


    }

    private fun prepare(){
        dataName=resources.getStringArray(R.array.data_name)
        dataDetail=resources.getStringArray(R.array.data_description)
        dataPhoto=resources.obtainTypedArray(R.array.data_photo)

        for (position in dataName.indices){
            dataHeroes.add(
                Hero(
                name = dataName[position],
                description = dataName[position],
                photo = dataPhoto.getResourceId(position,-1)
            ))
        }
    }


}