package com.sina.loginproject.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * From table_user Where userId=:id")
    fun getUserById(id:Int):User

    @Query("Select emailAddress From table_user")
    fun getAllEmails():MutableList<String>

    @Query("SELECT password FROM table_user WHERE emailAddress= :ea")
    fun getPassWithEmail(ea:String):String

}