package com.feylabs.myservice

import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var mServiceBound = false
    private lateinit var mBoundService: MyBoundService
    private  lateinit var zhuliReceiver: BroadcastReceiver



    private val mServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName) {
            mServiceBound = false
        }

        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            val myBinder = service as MyBoundService.MyBinder
            mBoundService = myBinder.getService
            mServiceBound = true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnStartService = findViewById<Button>(R.id.btn_start_service)

        btnStartService.setOnClickListener {
            val mStartServiceIntent = Intent(this, MyService::class.java)
            startService(mStartServiceIntent)
        }

        val btnStartJobIntentService = findViewById<Button>(R.id.btn_start_job_intent_service)
        btnStartJobIntentService.setOnClickListener {
            val mStartIntentService = Intent(this, MyJobIntentService::class.java)
            mStartIntentService.putExtra(MyJobIntentService.EXTRA_DURATION, 5000L)
            mStartIntentService.putExtra(MyJobIntentService.COMMAND, "ZHU LI , DO THE THINGS")
            startService(mStartIntentService)
//            MyJobIntentService.setEnqueueWork(this, mStartIntentService)
        }
        val btnStartBoundService = findViewById<Button>(R.id.btn_start_bound_service)
        btnStartBoundService.setOnClickListener {
            val mBoundServiceIntent = Intent(this, MyBoundService::class.java)
            bindService(mBoundServiceIntent, mServiceConnection, BIND_AUTO_CREATE)
        }
        val btnStopBoundService = findViewById<Button>(R.id.btn_stop_bound_service)
        btnStopBoundService.setOnClickListener {
            unbindService(mServiceConnection)
        }

        zhuliReceiver = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                Log.d("BROADCAST_MESSEJ","Broadcast Zhu Li Diterima");
                Toast.makeText(applicationContext,intent?.getStringExtra(MyJobIntentService.BROADCAST_COMMAND_STATUS).toString()
                ,Toast.LENGTH_SHORT).show()
            }
        }

        registerReceiver(zhuliReceiver,IntentFilter(MyJobIntentService.COMMAND_INTENT))



    }

    override fun onDestroy() {
        super.onDestroy()
        if (mServiceBound) {
            unbindService(mServiceConnection)
        }
    }
}