package com.feylabs.codelab_one.ViewModel

import androidx.lifecycle.ViewModel
import com.feylabs.codelab_one.Model.BookModel

class BookViewModel() : ViewModel() {

    var bookModel = BookModel()

    fun fetchBook(): MutableList<BookModel> {
        return bookModel.fetchBook()
    }

    fun setBook(mutableList: MutableList<BookModel>){
        bookModel.setBook(mutableList)
    }


}