package com.feylabs.unittesting

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.feylabs.unittesting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    lateinit var viewBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        mainViewModel = MainViewModel(CuboidModel())

        viewBinding.apply {
            btnSave.setOnClickListener {
                val length = edtLength.text.trim().toString()
                val width = edtWidth.text.trim().toString()
                val height = edtHeight.text.trim().toString()
                Log.d("Length" , length)
                Log.d("Width" , width)
                Log.d("Height" , height)
                Toast.makeText(applicationContext,"Test",Toast.LENGTH_LONG).show()
                when {
                    length.isBlank() -> edtLength.error = "Please fill this field"
                    width.isBlank() -> edtWidth.error = "Please fill this field"
                    height.isBlank() -> edtHeight.error = "Please fill this field"
                    else -> {
                        visible()
                        val l = length.toDouble()
                        val w = width.toDouble()
                        val h = height.toDouble()
                        mainViewModel.save(l, w, h)

                        btnCalculateCircumference.setOnClickListener {
                            tvResult.text = mainViewModel.getCircumference().toString()
                            gone()
                        }
                        btnCalculateSurfaceArea.setOnClickListener {
                            tvResult.text = mainViewModel.getSurfaceArea().toString()
                            gone()
                        }
                        btnCalculateVolume.setOnClickListener {
                            tvResult.text = mainViewModel.getVolume().toString()
                            gone()
                        }
                    }
                }
            }
        }
    }

    private fun visible() {
        viewBinding.apply {
            btnCalculateVolume.visibility = View.VISIBLE
            btnCalculateCircumference.visibility = View.VISIBLE
            btnCalculateSurfaceArea.visibility = View.VISIBLE
            btnSave.visibility = View.GONE
        }
    }

    private fun gone() {
        viewBinding.apply {
            btnCalculateVolume.visibility = View.GONE
            btnCalculateCircumference.visibility = View.GONE
            btnCalculateSurfaceArea.visibility = View.GONE
            btnSave.visibility = View.VISIBLE
        }
    }

}