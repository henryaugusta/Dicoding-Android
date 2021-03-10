package com.feylabs.codelab_one.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.feylabs.codelab_one.Model.BookModel
import com.feylabs.codelab_one.R
import com.feylabs.codelab_one.databinding.ListBookBinding

class BookListAdapter(val context: Context) : BaseAdapter() {
    var books = mutableListOf<BookModel>()
    lateinit var bookInterfaceList: BookAdapterInterface

    fun setBook(books: MutableList<BookModel>) {
        this.books = books;
    }

    fun setBookListInterface(bookAdapterInterface: BookAdapterInterface) {
        bookInterfaceList = bookAdapterInterface
    }

    override fun getCount(): Int {
        return books.size
    }

    override fun getItem(position: Int): Any {
        return books[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView =
                LayoutInflater.from(context).inflate(R.layout.list_book, parent, false)
        }

        val bookVIewHolder = BookVIewHolder(itemView as View)
        val book = getItem(position) as BookModel
        bookVIewHolder.bind(book)
        return itemView
    }

    inner class BookVIewHolder(view: View) {
        var binding = ListBookBinding.bind(view)
        fun bind(book: BookModel) {
            binding.apply {
                labelBookTitle.text = book.title
                labelBookAuthor.text = book.author
                labelBookDesc.text = book.desc
                imageRv.setImageResource(book.image)
                btnSeeDetail.setOnClickListener {
                    bookInterfaceList.onClick(book)
                }
                root.setOnClickListener {
                    bookInterfaceList.onClick(book)
                }
            }
        }
    }

    interface BookAdapterInterface {
        public fun onClick(book: BookModel)
    }
}