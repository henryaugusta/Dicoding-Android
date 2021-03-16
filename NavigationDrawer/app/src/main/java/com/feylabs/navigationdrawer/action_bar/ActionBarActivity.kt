package com.feylabs.navigationdrawer.action_bar

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.feylabs.navigationdrawer.R
import com.feylabs.navigationdrawer.databinding.ActivityActionBarBinding

class ActionBarActivity : AppCompatActivity() {
    lateinit var binding: ActivityActionBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActionBarBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_action_bar)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.option_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.search)?.actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = "Mau Cari Apa Hayo ?"


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            //Listen on submit
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(applicationContext, query.toString(), Toast.LENGTH_LONG).show()
                return true
            }

            //OnKeyUp  / Listen every single char of query
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, MenuFragment())
                    .addToBackStack(null)
                    .commit()
                return true
            }
            R.id.menu2 -> {
                val i = Intent(this, MenuActivity::class.java)
                startActivity(i)
                return true
            }

            R.id.menu4 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ConstructionFragment())
                    .addToBackStack(null)
                    .commit()
                return true
            }
            else -> {
                return true
            }
        }

    }

}