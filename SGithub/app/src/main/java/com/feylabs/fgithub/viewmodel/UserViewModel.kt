package com.feylabs.fgithub.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.feylabs.fgithub.model.SearchResult
import com.feylabs.fgithub.util.Endpoint
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import org.json.JSONArray
import org.json.JSONObject


class UserViewModel : ViewModel() {
    val searchResultQuery = MutableLiveData<MutableList<SearchResult>>()

    fun searchUser(query: String) {
        Log.d("query", query)
        AndroidNetworking.get("${Endpoint.BASE_URL}/search/users")
            .addHeaders("Authorization", Endpoint.TOKEN)
            .addQueryParameter("q", query)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.d("responsez", response.toString())
                    val item = response.getJSONArray("items")
                    processUserData(item)
                }

                override fun onError(anError: ANError?) {
                    Log.d("responsez_error", anError?.message.toString())
                    Log.d("responsez_error_body", anError?.errorBody.toString())
                    Log.d("responsez_error_body", anError?.errorDetail.toString())
                }
            })
    }

    fun processUserData(item: JSONArray) {
        runBlocking {
            val dataUserFromAPI = ArrayList<SearchResult>()
            for (i in 0 until item.length()) {
                item.apply {
                    val name = async { getUserName(getJSONObject(i).getString("login")) }
                    dataUserFromAPI.add(
                        (SearchResult(
                            getJSONObject(i).getString("url"),
                            getJSONObject(i).getString("login"),
                            name.await(),
                            getJSONObject(i).getString("avatar_url")
                        ))
                    )
                }
            }
            searchResultQuery.postValue(dataUserFromAPI)
        }
    }


    private fun getUserName(username: String): String {
        var name = ""
        AndroidNetworking.get("${Endpoint.BASE_URL}/users/$username")
            .addHeaders("Authorization", Endpoint.TOKEN)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    name = response?.getString("name").toString()
                }

                override fun onError(anError: ANError?) {
                    Log.d("ERROR_FAN_USERVIEWMODEL", anError.toString())
                    Log.d("ERROR_FAN_USERVIEWMODEL", anError?.localizedMessage.toString())
                    Log.d("ERROR_FAN_USERVIEWMODEL", anError?.errorBody.toString())
                }

            })

        return name

    }

    fun getUserList(): LiveData<MutableList<SearchResult>> {
        return searchResultQuery
    }

}

