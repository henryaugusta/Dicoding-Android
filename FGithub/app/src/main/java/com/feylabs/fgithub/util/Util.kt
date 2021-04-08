package com.feylabs.fgithub.util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.lang.Appendable

class Util() {
    companion object {
        private const val IS_LOGIN = "IS_LOGIN"

        fun checkFirstLogin(context: Context): Boolean {
            val pref = MySharedPreferences(context)
            return if (pref.getPrefBool(IS_LOGIN) == false) {
                pref.save(IS_LOGIN, true)
                false
            } else {
                true
            }
        }

        fun setFullScreen(activity: Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                activity.window.insetsController?.hide(WindowInsets.Type.statusBars())
            } else {
                activity.window.setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
                )
            }
        }

        fun hideActionBar(context: AppCompatActivity){
            context.actionBar?.hide()
            context.supportActionBar?.hide();
        }

        fun configStatusBarColor(mContext: Activity, color: Int) {
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
            mContext.window.statusBarColor = ContextCompat.getColor(mContext, color)
        }
    }

}