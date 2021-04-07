package com.feylabs.fgithub.view.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.feylabs.fgithub.R
import com.feylabs.fgithub.databinding.ActivityDetailUserBinding
import com.feylabs.fgithub.model.SearchResult
import com.feylabs.fgithub.model.User
import com.feylabs.fgithub.util.BaseActivity
import com.feylabs.fgithub.util.Util
import com.feylabs.fgithub.view.fragment.FollowFragment
import com.feylabs.fgithub.view.fragment.HomeFragment
import com.feylabs.fgithub.viewmodel.DetailViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso


class DetailUserActivity : BaseActivity() {

    lateinit var viewbind: ActivityDetailUserBinding
    lateinit var detailViewModel: DetailViewModel
    var urlFollowing = ""
    var urlFollowers = ""
    private val followFragment =
        FollowFragment()

    companion object {
        const val URL = "url"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbind = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(viewbind.root)

        Util.hideActionBar(this)

        
        viewbind.backButton.setOnClickListener {
            super.onBackPressed()
        }


        val urlDetail = intent.getParcelableExtra<SearchResult>(HomeFragment.USER)?.url.toString()
        setUpDetailViewModel(urlDetail)


        val mFragmentManager = supportFragmentManager
        mFragmentManager
            .beginTransaction()
            .add(R.id.nav_host_fragment,
                FollowFragment(), HomeFragment::class.java.simpleName)
            .commit()

        val bottomNav = viewbind.navView
        bottomNav.setOnNavigationItemSelectedListener(bottomNavListener)


    }

    private fun setUpDetailViewModel(urlDetail : String) {
        detailViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(DetailViewModel::class.java)

        detailViewModel.getDetail(urlDetail)
        viewbind.progressBar.visibility = View.VISIBLE

        detailViewModel.userResult.observe(this, Observer {
            if (it != null) {
                it.name?.showLongToast()
                viewbind.progressBar.visibility = View.GONE
                setUserView(it)
            } else {
                viewbind.progressBar.visibility = View.VISIBLE
            }
        })
    }

    val bottomNavListener = BottomNavigationView.OnNavigationItemSelectedListener { menu ->
        when (menu.itemId) {
            R.id.navigation_followers -> {
                val bundle = Bundle()
                val fragment = FollowFragment()
                bundle.putString(URL, urlFollowers)
                addFragment(fragment, bundle)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_following -> {
                val bundle = Bundle()
                val fragment = FollowFragment()
                bundle.putString(URL, urlFollowing)
                addFragment(fragment, bundle)
                return@OnNavigationItemSelectedListener true
            }
            else -> {
                false
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setUserView(it: User?) {
        viewbind.apply {
            labelUserName.text = it?.name
            labelUserUsername.text = it?.username
            userCompany.text = it?.company
            userLocation.text = it?.location
            userFollowers.text = "${getString(R.string.following_z)} ${it?.followingCount}"
            userFollowing.text = "${getString(R.string.followers_z)} ${it?.followersCount}"
            userRepoCount.text = "${getString(R.string.repo_count)} : ${it?.repoCount}"
            userRepoBio.text = "${getString(R.string.user_bio)} : ${it?.bio}"

            urlFollowers = "${it?.url.toString()}/followers"
            urlFollowing = "${it?.url.toString()}/following"

            val bundles = Bundle()
            bundles.putString("url", urlFollowers)
            addFragment(followFragment,bundles)

            Picasso.get()
                .load(it?.photo)
                .into(viewbind.userPhoto)
        }
    }

    private fun addFragment(fragment: Fragment, bundle: Bundle) {
        fragment.arguments = bundle
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.design_bottom_sheet_slide_in,
                R.anim.design_bottom_sheet_slide_out
            )
            .replace(R.id.nav_host_fragment, fragment, fragment.javaClass.simpleName)
            .commit()
    }


}