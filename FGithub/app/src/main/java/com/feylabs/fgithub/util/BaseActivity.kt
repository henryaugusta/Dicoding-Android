package com.feylabs.fgithub.util

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.feylabs.fgithub.R
import www.sanju.motiontoast.MotionToast

open class BaseActivity : AppCompatActivity() {

    fun String.showLongToast(){
        Toast.makeText(this@BaseActivity,this,Toast.LENGTH_LONG).show()
    }

    fun showSuccessToast(title:String,message:String){
        MotionToast.createColorToast(this,
            title,
            message,
            MotionToast.TOAST_SUCCESS,
            MotionToast.GRAVITY_BOTTOM,
            MotionToast.LONG_DURATION,
            ResourcesCompat.getFont(this, R.font.helvetica_regular))
    }
}