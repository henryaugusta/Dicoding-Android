package com.firriezky.dicoding._1_Intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firriezky.dicoding.R

class MoveWithResultDef : AppCompatActivity() {
    companion object {
        const val RESULT_CODE = 800
        const val SENDED_VALUE = "constnya"
        const val SENDED_VALUE2 = "csonstnya"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_result_def)

        val intent = Intent()
        intent.putExtra(SENDED_VALUE,"Razky Febriansyah")
        intent.putExtra(SENDED_VALUE2,"Firriezky")
        setResult(RESULT_CODE,intent)
        finish()
    }
}