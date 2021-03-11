package com.feylabs.codelab_one.ViewModel

import androidx.lifecycle.ViewModel
import com.feylabs.codelab_one.Model.UserModel

class UserViewModel() : ViewModel() {

    var userModel= UserModel()

    fun fetchUser(): MutableList<UserModel> {
        return userModel.fetchBook()
    }

    fun setUser(mutableList: MutableList<UserModel>){
        userModel.setBook(mutableList)
    }


}