package com.sina.loginproject.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class MyRoomDb : RoomDatabase() {
    abstract fun getUserDao(): UserDao

    companion object {
        private var INSTANCE: MyRoomDb? = null
        private const val DB_NAME = "user.db"

        fun getDatabase(context: Context): MyRoomDb? {
            if (INSTANCE == null) {
                synchronized(MyRoomDb::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            Room.databaseBuilder(context, MyRoomDb::class.java, DB_NAME)
                                .allowMainThreadQueries()
                                .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}