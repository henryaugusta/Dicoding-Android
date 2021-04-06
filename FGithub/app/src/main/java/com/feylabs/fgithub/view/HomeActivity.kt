package com.feylabs.fgithub.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import com.feylabs.fgithub.R
import com.feylabs.fgithub.databinding.ActivityHomeBinding
import com.feylabs.fgithub.util.BaseActivity
import com.feylabs.fgithub.util.Util

class HomeActivity : BaseActivity() {
    lateinit var vbinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vbinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(vbinding.root)

        actionBar?.hide()
        supportActionBar?.hide();
        showSuccessToast("Hallo","Selamat Datang")


        vbinding.topNavigationConstraint.setNavigationChangeListener { view, position ->
            when (position) {
                0 -> {
                    replaceFragment(HomeFragment())
                }
                1 -> {
                    replaceFragment(SettingsFragment())
                }
                2 -> {
                    replaceFragment(AboutFragment())
                }
            }
        }

        val mFragmentManager = supportFragmentManager
        val mHomeFragment = HomeFragment()
        mFragmentManager
            .beginTransaction()
            .add(R.id.fragNavHost, mHomeFragment, HomeFragment::class.java.simpleName)
            .commit()

    }

    private fun replaceFragment(fragment: Fragment) {
        val mFragmentManager = supportFragmentManager
        mFragmentManager.beginTransaction()
            .replace(R.id.fragNavHost, fragment)
            .addToBackStack(null)
            .commit()
    }
}