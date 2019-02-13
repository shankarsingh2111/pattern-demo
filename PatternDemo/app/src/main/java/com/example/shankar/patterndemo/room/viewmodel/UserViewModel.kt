package com.example.shankar.patterndemo.room.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.shankar.patterndemo.room.db.UserRepository
import com.example.shankar.patterndemo.room.model.User

class UserViewModel(val myApplication: Application) : AndroidViewModel(myApplication) {

    private var repository:UserRepository = UserRepository(myApplication)
    var allUsers: LiveData<List<User>>

    init{
        allUsers = repository.allUsers
    }

    public fun insert(user: User){
        repository.insert(user)
    }

}