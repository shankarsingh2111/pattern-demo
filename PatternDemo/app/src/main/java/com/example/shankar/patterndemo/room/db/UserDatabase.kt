package com.example.shankar.patterndemo.room.db

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.os.AsyncTask
import com.example.shankar.patterndemo.room.model.User
import com.example.shankar.patterndemo.room.model.UserDAO

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase(){

    companion object {
        @Volatile
        private var instance : UserDatabase? = null

        fun getInstance(context : Context):UserDatabase?{
            if(instance == null){
                synchronized(UserDatabase::class.java){
                    if(instance == null){
                        instance = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "db_user")
                                .fallbackToDestructiveMigration()
                                .addCallback(callback).build()
                    }
                }
            }
            return instance
        }

        private val callback: RoomDatabase.Callback = object : RoomDatabase.Callback(){
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                PopulateDBAsync(instance!!)
            }
        }
    }


    abstract fun getUserDao(): UserDAO



    class PopulateDBAsync(var userDatabase: UserDatabase) : AsyncTask<Unit, Unit, Unit>(){
        private val userDao:UserDAO = userDatabase.getUserDao()

        override fun doInBackground(vararg params: Unit?) {
            userDao.deleteAll()
            var user = User("Hello")
            userDao.insert(user)
            user = User("World")
            userDao.insert(user)
        }

    }
}