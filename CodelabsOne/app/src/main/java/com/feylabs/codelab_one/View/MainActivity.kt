package com.feylabs.codelab_one.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.feylabs.codelab_one.R
import com.feylabs.codelab_one.Util.Util
import com.feylabs.codelab_one.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initSplashData()

        //Check if this the first time user open the app
        // if true immediatelly move to second activity
        if (Util.checkFirstLogin(this)) {
            moveNext()
        }
    }


    private fun moveNext() {
        startActivity(Intent(this, ListViewActivity::class.java))
        finish()
    }

    private fun initSplashData() {
        val cursorImage = listOf(
            R.drawable.ic_cursor1,
            R.drawable.ic_cursor2,
            R.drawable.ic_cursor3
        )

        val onBoardImage = listOf(
            R.drawable.ic_onboarding1,
            R.drawable.ic_onboarding2,
            R.drawable.ic_onboarding3
        )

        val textList = listOf(
            getString(R.string.start_reading_for_your_future_investment),
            getString(R.string.keep_upgraded),
            getString(R.string.only_best_book)
        )


        //State define position of  splash image that showed into user
        var state = 0;
        viewBinding.buttonNext.setOnClickListener {
            state++
            if (state < textList.size) {
                viewBinding.let {
                    it.title.text = textList[state]
                    it.imageCursor.setBackgroundResource(cursorImage[state])
                    it.imageOnboarding.setBackgroundResource((onBoardImage[state]))
                }

            } else {
                moveNext()
            }
        }

    }
}