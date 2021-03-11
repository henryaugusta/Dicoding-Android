package com.feylabs.codelab_one.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.feylabs.codelab_one.Model.UserModel
import com.feylabs.codelab_one.R
import com.feylabs.codelab_one.databinding.ListUserBinding

class UserAdapter(val context: Context) : BaseAdapter() {
    var users = mutableListOf<UserModel>()
    lateinit var userInterfaceList: UserAdapterInterface

    fun setUser(users: MutableList<UserModel>) {
        this.users = users;
    }

    fun setBookListInterface(bookAdapterInterface: UserAdapterInterface) {
        userInterfaceList = bookAdapterInterface
    }

    override fun getCount(): Int {
        return users.size
    }

    override fun getItem(position: Int): Any {
        return users[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView =
                LayoutInflater.from(context).inflate(R.layout.list_user, parent, false)
        }

        val bookVIewHolder = BookVIewHolder(itemView as View)
        val book = getItem(position) as UserModel
        bookVIewHolder.bind(book)
        return itemView
    }

    inner class BookVIewHolder(view: View) {
        var binding = ListUserBinding.bind(view)
        @SuppressLint("SetTextI18n")
        fun bind(user: UserModel) {
            binding.apply {
                labelUserUsername.text = user.name
                labelUserFollowers.text="Followers ${user.followers}"
                labelUserFollowing.text="Following ${user.following}"
                labelUserRepository.text="Repository : ${user.repo}"

                imageRv.setImageResource(user.image)
                btnSeeDetail.setOnClickListener {
                    userInterfaceList.onClick(user)
                }
                root.setOnClickListener {
                    userInterfaceList.onClick(user)
                }
            }
        }
    }

    interface UserAdapterInterface {
        public fun onClick(user: UserModel)
    }
}