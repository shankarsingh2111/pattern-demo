package com.example.shankar.patterndemo.room.model

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.annotation.NonNull

@Entity(tableName = "tb_users")
class User(
        @NonNull
        @ColumnInfo(name = "userName")
        val name:String
){

    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}

@Dao
interface UserDAO{
    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insert(user:User)

    @Update
    fun update(user:User)

    @Delete
    fun delete(user:User)

    @Query("DELETE FROM tb_users")
    fun deleteAll()

    @Query("SELECT * FROM tb_users")
    fun getAllWords() : LiveData<List<User>>

}