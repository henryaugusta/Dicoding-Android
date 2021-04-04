package com.feylabs.myservice

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class MyJobIntentService : JobIntentService() {

    var command = "Default Command"

    companion object{
        private const val JOB_ID = 1000
        internal const val EXTRA_DURATION = "extra_duration"
        internal const val COMMAND = "extra_dSSuration"
        internal const val COMMAND_INTENT = "ZOMCS"
        internal const val BROADCAST_COMMAND_STATUS = "ZOMxCS"
        private val TAG = MyJobIntentService::class.java.simpleName

        fun setEnqueueWork(context: Context,intent: Intent){
            //register enqueue work
//            enqueueWork(context,MyJobIntentService::class.java, JOB_ID,intent)
        }

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        command = intent?.getStringExtra(COMMAND).toString()
        if (intent != null) {
            enqueueWork(this, this::class.java, 101, intent)
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onHandleWork(intent: Intent) {
        Log.d(TAG, "onHandleWork: Mulai.....")
        val duration = intent.getLongExtra(EXTRA_DURATION, 0)

        val intent = Intent(COMMAND_INTENT)
        if (command=="ZHU LI , DO THE THINGS"){
            intent.putExtra(BROADCAST_COMMAND_STATUS,"Your Command is : $command , my Response : Yes Sir !")
        }else{
            intent.putExtra(BROADCAST_COMMAND_STATUS,"Your Command is : $command , my Response : Is That You ?")
        }
        sendBroadcast(intent)

        try {
            Thread.sleep(duration)
            Log.d(TAG, "onHandleWork: Selesai.....")

        } catch (e: InterruptedException) {
            e.printStackTrace()
            Thread.currentThread().interrupt()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }


}