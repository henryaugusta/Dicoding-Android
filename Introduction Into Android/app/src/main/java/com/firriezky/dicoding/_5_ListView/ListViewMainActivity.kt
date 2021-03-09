package com.firriezky.dicoding._5_ListView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.firriezky.dicoding.R
import com.firriezky.dicoding.databinding.ActivityListViewMainBinding

class ListViewMainActivity : AppCompatActivity() {

    lateinit var binding : ActivityListViewMainBinding

    val dataName = arrayListOf("Razky","Henry","Syakir","Ahmad")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1)




    }
}