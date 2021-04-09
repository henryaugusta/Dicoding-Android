package com.feylabs.fgithub.util

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.feylabs.fgithub.R
import www.sanju.motiontoast.MotionToast

open class BaseFragment : Fragment() {

    fun String.showLongToast(){
        Toast.makeText(requireContext(),this,Toast.LENGTH_LONG).show()
    }

    fun showMotionToast(title:String,message:String,type:String){
        MotionToast.createColorToast(requireActivity(),
            title,
            message,
            type,
            MotionToast.GRAVITY_BOTTOM,
            MotionToast.LONG_DURATION,
            ResourcesCompat.getFont(requireContext(),R.font.helvetica_regular))
    }
}