
package com.feylabs.codelab_one.Model

import android.os.Parcel
import android.os.Parcelable
import com.feylabs.codelab_one.R


class UserModel() : Parcelable {

    lateinit var userList : MutableList<UserModel>
    lateinit var name : String
    lateinit var username : String
    lateinit var followers : String
    lateinit var following: String
    lateinit var repo: String
    lateinit var company: String
    lateinit var location: String
    var image : Int = R.drawable.user10

    constructor(parcel: Parcel) : this() {
        name = parcel.readString().toString()
        username = parcel.readString().toString()
        followers = parcel.readString().toString()
        following = parcel.readString().toString()
        repo = parcel.readString().toString()
        company = parcel.readString().toString()
        location = parcel.readString().toString()
        image = parcel.readInt()
    }


    fun setBook(mutableList: MutableList<UserModel>){
        this.userList = mutableList
    }

    fun fetchBook(): MutableList<UserModel> {
        return this.userList
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(username)
        parcel.writeString(followers)
        parcel.writeString(following)
        parcel.writeString(repo)
        parcel.writeString(company)
        parcel.writeString(location)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserModel> {
        override fun createFromParcel(parcel: Parcel): UserModel {
            return UserModel(parcel)
        }

        override fun newArray(size: Int): Array<UserModel?> {
            return arrayOfNulls(size)
        }
    }


}