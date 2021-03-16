package com.feylabs.navigationdrawer.ui.razky

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RazkyViewModel : ViewModel() {

    private var _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    fun setUserName(name : String){
        this._text.value=name.toString()
    }

}