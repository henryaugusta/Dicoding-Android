package com.firriezky.dicoding._1_Intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.firriezky.dicoding._1_Intent.parcelable.IntentParcelDestination
import com.firriezky.dicoding._1_Intent.parcelable.Person
import com.firriezky.dicoding.databinding.Activity11IntentBinding

class C1_1_Intent : AppCompatActivity(){

    lateinit var binding : Activity11IntentBinding

    companion object{
        const val NAME = "NAME"
        const val AGE = "AGE"
        const val PERSON = "PERSON"
        const val REQUEST_CODE = 777
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity11IntentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.intentNorm.setOnClickListener {
            val letsMove = Intent(this,MoveActivity::class.java)
            startActivity(letsMove)
        }

        binding.intentWithData.setOnClickListener {
            val letsMove = Intent(this,MoveActivity::class.java)
            letsMove.putExtra(NAME,"Razky Febriansyah")
            letsMove.putExtra(AGE,15)
            startActivity(letsMove)
        }

        binding.dialANumber.setOnClickListener {
            val letsMove = Intent(Intent.ACTION_DIAL, Uri.parse("tel:088223738709"))
            startActivity(letsMove)
        }

        binding.intentResultLatihan.setOnClickListener {
            val letsMove = Intent(this,LatihanMoveWithResult::class.java)
            startActivityForResult(letsMove, REQUEST_CODE)
        }

        binding.intentParcelize.setOnClickListener {
            val person : Person = Person(
                name = "Razky Febriansyah",
                age = 14,
                gender = 1,
                city = "Jakarta"
            )
            val letsMoveWithIntent = Intent(this,IntentParcelDestination::class.java)
            letsMoveWithIntent.putExtra(PERSON,person)
            startActivity(letsMoveWithIntent)
        }

        binding.btnMoveForResult.setOnClickListener {
            val moveForResultIntent = Intent(this, MoveWithResultActivity::class.java)
            startActivityForResult(moveForResultIntent, REQUEST_CODE)
        }

        binding.btnMoveForResult2.setOnClickListener {
            val moveForResultIntent = Intent(this, MoveWithResultDef::class.java)
            startActivityForResult(moveForResultIntent, REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveWithResultActivity.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(MoveWithResultActivity.EXTRA_SELECTED_VALUE, 0)
                binding.tvResult.text = "Hasil : $selectedValue"
            }

            if (resultCode==LatihanMoveWithResult.LATIHAN_MOVE_RESULT_CODE){
                Toast.makeText(this,data?.getStringExtra(LatihanMoveWithResult.MESSAGE_FROM_LATIHAN)
                    ,Toast.LENGTH_LONG).show()
                binding.tvResult.text = "Hasil : ${data?.getStringExtra(LatihanMoveWithResult.MESSAGE_FROM_LATIHAN)}"

            }

            if (resultCode == MoveWithResultDef.RESULT_CODE){
                val resultValue : String = data?.getStringExtra(MoveWithResultDef.SENDED_VALUE) ?: "Tidak Ada"
                val resultValue2 : String = data?.getStringExtra(MoveWithResultDef.SENDED_VALUE2) ?: "Tidak Ada"
                binding.tvResult.text = "Activity Result Kedua :  \n $resultValue \n $resultValue2"
            }
        }

    }

}