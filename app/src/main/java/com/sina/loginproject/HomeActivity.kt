package com.sina.loginproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val currentUser=intent.getParcelableExtra<User>("currentUser")
        tvShowCurrentUser.text="""
            Email: ${currentUser?.emailAddress}
            Password: ${currentUser?.password}
        """.trimIndent()
    }
}