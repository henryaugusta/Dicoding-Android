package com.feylabs.codelab_one.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.feylabs.codelab_one.Model.BookModel
import com.feylabs.codelab_one.R
import com.feylabs.codelab_one.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val getParcel = intent.getParcelableExtra<BookModel>(ListViewActivity.BOOK_PARCEL)

        viewBinding.apply {
            labelBookAuthor.text= getParcel?.author.toString()
            labelBookDesc.text=getParcel?.desc.toString()
            labelBookTitle.text=getParcel?.title.toString()

            Glide.with(applicationContext)
                .load(getParcel?.image)
                .into(imageDest)
        }

    }
}