package com.firriezky.dicoding._1_Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firriezky.dicoding.R
import com.firriezky.dicoding.databinding.ActivityMoveBinding

class MoveActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_NAME = "NAME"
        const val EXTRA_AGE = "AGE"
    }
    lateinit var binding : ActivityMoveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra(EXTRA_NAME) ?: "Tidak Ada"
        val age = intent.getIntExtra(EXTRA_AGE , 0) ?: "0"

        binding.txtResult.setText("$name, usia $age")

    }
}