package com.feylabs.fgithub.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.feylabs.fgithub.model.SearchResult
import com.feylabs.fgithub.model.User
import com.feylabs.fgithub.util.Endpoint
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.json.JSONArray
import org.json.JSONObject

class FollowViewModel : ViewModel() {

    val followData = MutableLiveData<MutableList<SearchResult>>()

    fun getFollowData(url: String) {
        AndroidNetworking.get(url)
            .addHeaders("Authorization", Endpoint.TOKEN)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {
                    parseData(response)
                }

                override fun onError(anError: ANError?) {
                    Log.d("responsexz_error", anError?.message.toString())
                    Log.d("responsexz_error_body", anError?.errorBody.toString())
                    Log.d("responsexz_error_body", anError?.errorDetail.toString())
                }

            })
    }

    private fun parseData(res: JSONArray) {
        val dataUserFromAPI = ArrayList<SearchResult>()
        for (i in 0 until res.length()) {
            res.apply {
                dataUserFromAPI.add(
                    (SearchResult(
                        getJSONObject(i).getString("url"),
                        getJSONObject(i).getString("login"),
                        null,
                        getJSONObject(i).getString("avatar_url")
                    ))
                )
            }
        }
        followData.postValue(dataUserFromAPI)
    }

}