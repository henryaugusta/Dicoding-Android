package com.feylabs.codelab_one.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.feylabs.codelab_one.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}