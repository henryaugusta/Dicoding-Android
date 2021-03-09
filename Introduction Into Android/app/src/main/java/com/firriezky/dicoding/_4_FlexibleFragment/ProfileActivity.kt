package com.firriezky.dicoding._4_FlexibleFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firriezky.dicoding.R
import com.firriezky.dicoding.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    lateinit var binding : ActivityProfileBinding

    companion object{
        const val PUTTY ="Putty"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.text.text=intent.getStringExtra(PUTTY)
    }
}