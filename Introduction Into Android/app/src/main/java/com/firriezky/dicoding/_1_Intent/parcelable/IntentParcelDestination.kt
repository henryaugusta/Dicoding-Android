package com.firriezky.dicoding._1_Intent.parcelable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firriezky.dicoding.R
import com.firriezky.dicoding._1_Intent.C1_1_Intent
import com.firriezky.dicoding.databinding.ActivityIntentParcelDestinationBinding

class IntentParcelDestination : AppCompatActivity() {
    lateinit var binding :ActivityIntentParcelDestinationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentParcelDestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = intent.getParcelableExtra<Person>(C1_1_Intent.PERSON)
        binding.tvObjectReceived.text=person.toString()
    }
}