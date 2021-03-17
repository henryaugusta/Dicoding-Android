package com.feylabs.navigationdrawer.bottom_navigation.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    var text = MutableLiveData<String>()

    fun setText(newText : String){
        text.value=newText
    }

}