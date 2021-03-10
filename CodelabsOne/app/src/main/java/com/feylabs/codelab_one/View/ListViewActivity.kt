package com.feylabs.codelab_one.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.feylabs.codelab_one.Adapter.BookListAdapter
import com.feylabs.codelab_one.Data.BookDataSource
import com.feylabs.codelab_one.Model.BookModel
import com.feylabs.codelab_one.ViewModel.BookViewModel
import com.feylabs.codelab_one.databinding.ActivityListViewBinding

class ListViewActivity : AppCompatActivity() {
    lateinit var viewBInding: ActivityListViewBinding
    lateinit var bookAdapter: BookListAdapter
    lateinit var bookViewModel: BookViewModel

    var tempBookData = mutableListOf<BookModel>()

    companion object{
        const val  BOOK_PARCEL = "JNE DISINI"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBInding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(viewBInding.root)

        tempBookData.addAll(BookDataSource.bookData)
        bookViewModel = BookViewModel()
        bookViewModel.setBook(tempBookData)

        bookAdapter = BookListAdapter(this).apply {
            setBook(bookViewModel.fetchBook())
            setBookListInterface(object : BookListAdapter.BookAdapterInterface {
                override fun onClick(book: BookModel) {
                    Toast.makeText(applicationContext, book.title, Toast.LENGTH_LONG).show()
                    val intent = Intent(applicationContext,DetailActivity::class.java)
                    intent.putExtra(BOOK_PARCEL,book)
                    startActivity(intent)
                }
            })
        }

        viewBInding.apply {
            listView.adapter = bookAdapter
            btnProfile.setOnClickListener {
             startActivity(Intent(applicationContext, ProfileActivity::class.java))
            }
        }



    }
}