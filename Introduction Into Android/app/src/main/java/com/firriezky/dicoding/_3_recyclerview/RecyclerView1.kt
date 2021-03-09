package com.firriezky.dicoding._3_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.firriezky.dicoding.R
import com.firriezky.dicoding._3_recyclerview.model.*
import com.firriezky.dicoding.databinding.ActivityRecyclerView1Binding

class RecyclerView1 : AppCompatActivity() {

    lateinit var binding : ActivityRecyclerView1Binding

    private var listHeros = arrayListOf<Hero>()
    private val HeroData = HeroData()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_rv,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerView1Binding.inflate(layoutInflater)
        setContentView(binding.root)


        listHeros.addAll(HeroData.listData)

        binding.rvHeroes.setHasFixedSize(true)
        showRv()
    }

    private fun setMode(selectedMode : Int){
        when (selectedMode){
            R.id.rv_list->{
                showRv()
            }
            R.id.rv_card->{
                showRecyclerGrid()
            }
            R.id.rv_grid->{
                showRecyclerImage()
            }
        }
    }

    fun showRv(){
        title = "List"
        binding.rvHeroes.layoutManager = LinearLayoutManager(this)
        val heroAdapter = HeroAdapter()

        heroAdapter.setHeroData(HeroData.listData)
        binding.rvHeroes.adapter = heroAdapter
    }

    fun showRecyclerGrid(){
        title = "Grid"
        binding.rvHeroes.layoutManager=GridLayoutManager(this,2)
        val gridHeroAdapter = GridHeroAdapter()
        gridHeroAdapter.setHeroData(HeroData.listData)
        binding.rvHeroes.adapter=gridHeroAdapter
    }

    fun showRecyclerImage(){
        title = "Card"
        binding.rvHeroes.layoutManager=LinearLayoutManager(this)
        val cardHeroAdapter = CardHeroAdapter()
        cardHeroAdapter.setHeroData(HeroData.listData)
        binding.rvHeroes.adapter=cardHeroAdapter
    }
}