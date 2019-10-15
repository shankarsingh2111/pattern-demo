package com.example.shankar.patterndemo.room.db

import android.app.Application
import androidx.lifecycle.LiveData
import android.os.AsyncTask
import com.example.shankar.patterndemo.room.model.User
import com.example.shankar.patterndemo.room.model.UserDAO

class UserRepository(application: Application){

    var userDao: UserDAO
    var allUsers: LiveData<List<User>>

    init{
        val ud: UserDatabase = UserDatabase.Companion.getInstance(application)!!
        userDao = ud.getUserDao()
        allUsers = userDao.getAllWords()
    }

    fun insert(user: User){
        InsertTask(userDao).execute(user)
    }

    private class InsertTask(val userDAO: UserDAO) : AsyncTask<User, Any, Any>() {

        override fun doInBackground(vararg params: User?) {
            userDAO.insert(params[0]!!)

        }

    }


}