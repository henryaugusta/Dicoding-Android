package com.feylabs.codelab_one.Model

import android.os.Parcel
import android.os.Parcelable
import com.feylabs.codelab_one.R


class BookModel() : Parcelable {

    lateinit var bookList : MutableList<BookModel>
    lateinit var title : String
    lateinit var desc : String
    lateinit var author : String
    var image : Int = R.drawable.book_being_had

    constructor(parcel: Parcel) : this() {
        title = parcel.readString().toString()
        desc = parcel.readString().toString()
        author = parcel.readString().toString()
        image = parcel.readInt()
    }

    fun setBook(mutableList: MutableList<BookModel>){
        this.bookList = mutableList
    }

    fun fetchBook(): MutableList<BookModel> {
        return this.bookList
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(desc)
        parcel.writeString(author)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BookModel> {
        override fun createFromParcel(parcel: Parcel): BookModel {
            return BookModel(parcel)
        }

        override fun newArray(size: Int): Array<BookModel?> {
            return arrayOfNulls(size)
        }
    }


}