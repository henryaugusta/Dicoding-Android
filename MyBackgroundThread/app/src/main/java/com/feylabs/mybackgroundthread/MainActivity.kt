package com.feylabs.mybackgroundthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btn_start)
        val tvStatus = findViewById<TextView>(R.id.tv_status)

        btnStart.setOnClickListener {
            try {
                //simulasi proses yang berat nan panjang
                for (i in 0..100){
                    Thread.sleep(500)
                    val percentage = i
                    if (percentage==100){
                        tvStatus.setText(R.string.task_completed)
                    }else{
                        tvStatus.text = String.format(getString(R.string.compressing),percentage)
                    }
                }

            }catch (e : Exception){
                e.printStackTrace()
            }
        }

    }
}