package com.firriezky.dicoding._1_Intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firriezky.dicoding.R
import com.firriezky.dicoding.databinding.ActivityMoveWithResultBinding

class MoveWithResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityMoveWithResultBinding

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMoveWithResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            btnChoose.setOnClickListener {

                if (rgNumber.checkedRadioButtonId > 0) {
                    var value = 0
                    when (rgNumber.checkedRadioButtonId) {
                        R.id.rb_50 -> value = 50
                        R.id.rb_100 -> value = 100
                        R.id.rb_150 -> value = 150
                        R.id.rb_200 -> value = 200
                    }

                    val resultIntent = Intent()
                    resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                    setResult(RESULT_CODE, resultIntent)
                    finish()

                }
            }


        }
    }
}