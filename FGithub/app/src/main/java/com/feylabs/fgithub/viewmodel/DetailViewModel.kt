package com.feylabs.fgithub.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.feylabs.fgithub.model.User
import com.feylabs.fgithub.util.Endpoint
import kotlinx.coroutines.launch
import org.json.JSONObject

class DetailViewModel : ViewModel() {

    val userResult = MutableLiveData<User>()

    fun getDetail(url: String) {
        viewModelScope.launch {
            AndroidNetworking.get(url)
                .addHeaders("token", Endpoint.TOKEN)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject) {
                        response.apply {

                            val tempUserModel = User(
                                url = getString("url"),
                                name = getString("name"),
                                blog = getString("blog"),
                                company = getString("company"),
                                followersCount = getInt("followers"),
                                followingCount = getInt("following"),
                                location = getString("location"),
                                repoCount = getString("public_repos"),
                                photo = getString("avatar_url"),
                                username = getString("login"),
                                followersLink = getString("followers_url"),
                                followingLink = getString("following_url"),
                                bio = getString("bio")
                            )
                            userResult.postValue(tempUserModel)
                        }

                    }

                    override fun onError(anError: ANError?) {
                        userResult.postValue(null)
                        Log.d("responsez_error", anError?.message.toString())
                        Log.d("responsez_error_body", anError?.errorBody.toString())
                        Log.d("responsez_error_body", anError?.errorDetail.toString())
                    }
                })
        }
    }


}