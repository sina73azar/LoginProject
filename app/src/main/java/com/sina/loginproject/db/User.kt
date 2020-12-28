package com.sina.loginproject.db

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "table_user")
data class User(
    @ColumnInfo
    val emailAddress: String?,
    @ColumnInfo
    val password: String?,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    val userId:Int=0
) : Parcelable

