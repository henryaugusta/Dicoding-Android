package com.feylabs.applicationuiandux.MyCustomView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.feylabs.applicationuiandux.R
import com.feylabs.applicationuiandux.databinding.ActivityMainCustomViewBinding

class MainCustomView : AppCompatActivity() {

    lateinit var binding : ActivityMainCustomViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCustomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.myEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                //DO NOTHING HERE
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                binding.myEditText.showClearButton()
                setMyButtonEnable()
            }
            override fun afterTextChanged(s: Editable) {
                if (binding.myEditText.text==null){
                    Toast.makeText(applicationContext,"Jangan Kosong Dong",Toast.LENGTH_LONG).show()
                }
            }
        })
        binding.myButton.setOnClickListener {
            Toast.makeText(this, binding.myEditText.text, Toast.LENGTH_SHORT).show() }
    }

    private fun setMyButtonEnable() {
        val result = binding.myEditText.text
        binding.myButton.isEnabled = result != null && result.toString().isNotEmpty()
    }

}