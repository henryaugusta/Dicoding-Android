package com.feylabs.localization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import com.feylabs.localization.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val pokeCount = 4
        val hello = resources.getString(R.string.hello_world,"Narenda Wicaksono",pokeCount,"Yoza Aprilio")

        viewBinding.tvHello.text = hello

//        val songCount = 5
//        val pluralText = resources.getQuantityString(R.plurals.numberOfSongsAvailable,songCount)
//        viewBinding.tvPlural.text = pluralText

        val songCount = 5
        val pluralText = resources.getQuantityString(R.plurals.numberOfSongsAvailable,songCount,songCount)
        viewBinding.tvPlural.text = pluralText

        viewBinding.tvXliff.text = resources.getString(R.string.app_homeurl)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.action_change_settings){
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }

        return super.onOptionsItemSelected(item)

    }
}