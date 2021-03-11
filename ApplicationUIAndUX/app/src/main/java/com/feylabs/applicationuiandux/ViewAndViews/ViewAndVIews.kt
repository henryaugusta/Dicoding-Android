package com.feylabs.applicationuiandux.ViewAndViews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.feylabs.applicationuiandux.R

class ViewAndVIews : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_and_views)

        supportActionBar?.title = "Google Pixel"
    }
}