package com.feylabs.fgithub.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.feylabs.fgithub.R
import com.feylabs.fgithub.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    lateinit var vbind : ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vbind = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(vbind.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu,menu)
        return super.onCreateOptionsMenu(menu)

    }
}