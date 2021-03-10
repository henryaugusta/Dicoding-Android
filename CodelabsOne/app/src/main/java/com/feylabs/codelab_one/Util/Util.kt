package com.feylabs.codelab_one.Util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.view.WindowInsets
import android.view.WindowManager
import androidx.core.content.ContextCompat

class Util {
    companion object{
       private const val  PREF_NAME = "PREFNAME"

        fun checkFirstLogin(context: Context) : Boolean{
            val preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME,0)
            return preferences.contains(PREF_NAME)
        }

        fun configStatusBarColor(mContext : Activity, color : Int ){
            //Set Fullscreen
            @Suppress("DEPRECATION")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                mContext.window.insetsController?.hide(WindowInsets.Type.statusBars())
            } else {
                mContext.window.setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
                )
            }
            mContext.window.statusBarColor = ContextCompat.getColor(mContext,color)
        }
    }


}