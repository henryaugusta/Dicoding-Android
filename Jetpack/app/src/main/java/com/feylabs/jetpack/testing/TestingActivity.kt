package com.feylabs.jetpack.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.feylabs.jetpack.R
import com.feylabs.jetpack.databinding.ActivityTestingBinding

class TestingActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var mainViewModel: MainViewModel

    val vbind by lazy { ActivityTestingBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vbind.root)

        mainViewModel = MainViewModel(CuboidModel())

        vbind.btnSave.setOnClickListener(this)
        vbind.btnCalculateSurfaceArea.setOnClickListener(this)
        vbind.btnCalculateCircumference.setOnClickListener(this)
        vbind.btnCalculateVolume.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val length = vbind.edtLength.text.toString().trim()
        val width = vbind.edtWidth.text.toString().trim()
        val height = vbind.edtHeight.text.toString().trim()
        when {
            TextUtils.isEmpty(length) -> {
                vbind.edtLength.error = "Field ini tidak boleh kosong"
            }
            TextUtils.isEmpty(width) -> {
                vbind.edtWidth.error = "Field ini tidak boleh kosong"
            }
            TextUtils.isEmpty(height) -> {
                vbind.edtHeight.error = "Field ini tidak boleh kosong"
            }
            else -> {
                val valueLength = length.toDouble()
                val valueWidth = width.toDouble()
                val valueHeight = height.toDouble()
                when (v.id) {
                    R.id.btn_save -> {
                        mainViewModel.save(valueLength, valueWidth, valueHeight)
                        visible()
                    }
                    R.id.btn_calculate_circumference -> {
                        vbind.tvResult.text = mainViewModel.getCircumference().toString()
                        gone()
                    }
                    R.id.btn_calculate_surface_area -> {
                        vbind.tvResult.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                    R.id.btn_calculate_volume -> {
                        vbind.tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun visible() {
        vbind.btnCalculateVolume.visibility = View.VISIBLE
        vbind.btnCalculateCircumference.visibility = View.VISIBLE
        vbind.btnCalculateSurfaceArea.visibility = View.VISIBLE
        vbind.btnSave.visibility = View.GONE
    }
    private fun gone() {
        vbind.btnCalculateVolume.visibility = View.GONE
        vbind.btnCalculateCircumference.visibility = View.GONE
        vbind.btnCalculateSurfaceArea.visibility = View.GONE
        vbind.btnSave.visibility = View.VISIBLE
    }

}