package com.firriezky.dicoding._4_FlexibleFragment.Exercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.firriezky.dicoding.R
import com.firriezky.dicoding.databinding.ActivitySocialBinding
import com.google.android.material.chip.Chip

class SocialActivity : AppCompatActivity() {
    lateinit var binding : ActivitySocialBinding
    lateinit var mFragmentManager : FragmentManager
    val fragmentKampus = KampusFragment()
    val fragmentMasjid = MasjidFragment()
    val fragmentCafe = CafeFragment()

    companion object{
        const val MOSQUE = "MOSQUE"
        const val CAFE = "CAFE"
        const val CAMPUS = "CAMPUS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySocialBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        chipListener()
        changeFragment(fragmentMasjid, MOSQUE)


        val fragment = mFragmentManager.findFragmentByTag(KampusFragment::class.java.simpleName)
        Log.d("FragmentName",fragment.toString())

    }


    private fun chipListener(){
        binding.chipContainer.setOnCheckedChangeListener { group, checkedId ->
            val chip: Chip? = group.findViewById(checkedId)

            when(chip?.id){
                R.id.chipFragmentCafe ->{
                    changeFragment(fragmentCafe, CAFE)
                }

                R.id.chipFragmentKampus ->{
                    changeFragment(fragmentKampus, CAMPUS)
                }

                R.id.chipFragmentMasjid ->{
                    changeFragment(fragmentMasjid, MOSQUE)
                }
            }
        }
    }

    fun changeFragment(fragment : Fragment,param:String){
        when(param){
            MOSQUE->{
                binding.chipFragmentMasjid.isActivated=true
                Toast.makeText(this, MOSQUE,Toast.LENGTH_LONG).show()

            }
        }
        mFragmentManager = supportFragmentManager
        mFragmentManager.beginTransaction()
            .replace(R.id.frameLayoutSocial,fragment)
            .addToBackStack(null)
            .commit()
    }




}