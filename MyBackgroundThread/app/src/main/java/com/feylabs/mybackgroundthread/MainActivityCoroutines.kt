package com.feylabs.mybackgroundthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.util.concurrent.Executors

class MainActivityCoroutines : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btn_start)
        val tvStatus = findViewById<TextView>(R.id.tv_status)



        btnStart.setOnClickListener {
            try {
                //simulate process in background thread
                lifecycleScope.launch {
                    for (i in 0..50) {
                        delay(100)
                        val percentage = i * 2

                        withContext(Dispatchers.Main) {
                            if (percentage == 100) {
                                tvStatus.setText(R.string.task_completed)
                            } else {
                                tvStatus.text =
                                    String.format(getString(R.string.compressing), percentage)
                            }
                        }
                        
                    }
                }


            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }

    }
}