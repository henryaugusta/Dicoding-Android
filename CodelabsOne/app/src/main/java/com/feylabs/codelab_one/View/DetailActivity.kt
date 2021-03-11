package com.feylabs.codelab_one.View

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.feylabs.codelab_one.Model.UserModel
import com.feylabs.codelab_one.R
import com.feylabs.codelab_one.Util.Util
import com.feylabs.codelab_one.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityDetailBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val getParcel = intent.getParcelableExtra<UserModel>(ListViewActivity.USER_PARCEL)
        Util.configStatusBarColor(this,R.color.design_default_color_on_primary)

        viewBinding.apply {
            labelUserUsername.text= getParcel?.username.toString()
            labelUserName.text=  getParcel?.name.toString()
            labelUserFollowers.text= getString(R.string.user_followers_l) +  getParcel?.followers.toString()
            labelUserFollowing.text= getString(R.string.user_following_l) +  getParcel?.following.toString()
            labelUserLocation.text= getString(R.string.user_location_l) +  getParcel?.location.toString()
            labelUserCompany.text = getString(R.string.company_l) +  getParcel?.company.toString()
            labelUserRepository.text= getString(R.string.repository_l) +  getParcel?.repo.toString()
            Glide.with(applicationContext)
                .load(getParcel?.image)
                .into(imageDest)
        }

    }
}