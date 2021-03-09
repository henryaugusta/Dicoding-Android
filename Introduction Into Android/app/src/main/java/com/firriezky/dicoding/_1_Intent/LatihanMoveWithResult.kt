package com.firriezky.dicoding._1_Intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firriezky.dicoding.R

class LatihanMoveWithResult : AppCompatActivity() {


    companion object{
        const val LATIHAN_MOVE_RESULT_CODE  = 1210
        const val MESSAGE_FROM_LATIHAN  = "SDFAQ"


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan_move_with_result)

        val intent = Intent()
        intent.putExtra(MESSAGE_FROM_LATIHAN,"DUNIA SEMENTARA , AKHIRAT SELAMANYA")
        setResult(LATIHAN_MOVE_RESULT_CODE,intent)
        finish()

    }
}