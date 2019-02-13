package com.example.shankar.patterndemo.room.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.shankar.patterndemo.R
import com.example.shankar.patterndemo.room.model.User

class UsersAdapter(): RecyclerView.Adapter<UsersAdapter.ViewHolderUser>(){
    private lateinit var users: List<User>

    fun setList(users:List<User>){
        this.users = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUser {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user, parent, false)
        return ViewHolderUser(itemView)
    }

    override fun getItemCount(): Int {
        return if(::users.isInitialized) users.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolderUser, position: Int) {
        holder.textView.text = users[position].name
    }


    class ViewHolderUser(view: View) : RecyclerView.ViewHolder(view){
        val textView:TextView = view.findViewById(R.id.textView)
    }
}