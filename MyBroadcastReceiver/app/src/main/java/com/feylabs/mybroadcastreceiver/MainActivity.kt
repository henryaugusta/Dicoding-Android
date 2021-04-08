package com.feylabs.mybroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.Manifest as manman
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.feylabs.mybroadcastreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var downloadReceiver: BroadcastReceiver

    companion object {
        private const val SMS_REQUEST_CODE = 101
        const val ACTION_DOWNLOAD_STATUS = "download_status"
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(downloadReceiver)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        downloadReceiver = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                Log.d(DownloadService.TAG, "Download Selesai")
                Toast.makeText(context, intent?.getStringExtra(DownloadService.DOWNLOAD_MESSAGE), Toast.LENGTH_SHORT).show()
            }
        }

        registerReceiver(downloadReceiver, IntentFilter(ACTION_DOWNLOAD_STATUS))

        binding.btnDownload.setOnClickListener {
            val downloadServiceIntent = Intent(this, DownloadService::class.java)
            startService(downloadServiceIntent)
        }

        binding.btnPermission.setOnClickListener {
            PermissionManager.check(this,manman.permission.RECEIVE_SMS, SMS_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == SMS_REQUEST_CODE) {
            when {
                grantResults[0] == PackageManager.PERMISSION_GRANTED -> Toast.makeText(this, "Sms receiver permission diterima", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, "Sms receiver permission ditolak", Toast.LENGTH_SHORT).show()
            }
        }
    }
}