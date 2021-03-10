package com.firriezky.dicoding

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firriezky.dicoding._1_Intent.C1_1_Intent
import com.firriezky.dicoding._3_recyclerview.RecyclerView1
import com.firriezky.dicoding._4_FlexibleFragment.Exercise.SocialActivity
import com.firriezky.dicoding._4_FlexibleFragment.MainActivityFragment
import com.firriezky.dicoding._5_ListView.ListViewMainActivity
import com.firriezky.dicoding.databinding.ActivityLandingBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityLandingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLandingBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            btnIntent.setOnClickListener {
                moveActivity(C1_1_Intent())
            }
            btnRv.setOnClickListener {
                moveActivity(RecyclerView1())
            }
            btnFragment.setOnClickListener {
                moveActivity(MainActivityFragment())
            }
            btnFragmentExercise.setOnClickListener {
                moveActivity(SocialActivity())
            }
            btnListVIew.setOnClickListener {
                moveActivity(ListViewMainActivity())
            }
        }

    }

    private fun moveActivity(act : Activity){
        startActivity(Intent(this,act::class.java))
    }


}