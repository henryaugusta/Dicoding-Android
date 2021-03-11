package com.feylabs.codelab_one.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.feylabs.codelab_one.Adapter.UserAdapter
import com.feylabs.codelab_one.Data.UserDataSource
import com.feylabs.codelab_one.Model.UserModel
import com.feylabs.codelab_one.ViewModel.UserViewModel
import com.feylabs.codelab_one.databinding.ActivityListViewBinding

class ListViewActivity : AppCompatActivity() {
    lateinit var viewBInding: ActivityListViewBinding
    lateinit var userAdapter: UserAdapter
    lateinit var userViewModel: UserViewModel

    var tempUserData = mutableListOf<UserModel>()

    companion object{
        const val  USER_PARCEL = "JNE DISINI"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBInding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(viewBInding.root)

        tempUserData.addAll(UserDataSource.userData)
        userViewModel = UserViewModel()
        userViewModel.setUser(tempUserData)

        userAdapter = UserAdapter(this).apply {
            setUser(userViewModel.fetchUser())
            setBookListInterface(object : UserAdapter.UserAdapterInterface {
                override fun onClick(user: UserModel) {
                    Toast.makeText(applicationContext, user.name, Toast.LENGTH_LONG).show()
                    val intent = Intent(applicationContext,DetailActivity::class.java)
                    intent.putExtra(USER_PARCEL,user)
                    startActivity(intent)
                }
            })
        }

        viewBInding.apply {
            listView.adapter = userAdapter
            btnProfile.setOnClickListener {
             startActivity(Intent(applicationContext, ProfileActivity::class.java))
            }
        }



    }
}