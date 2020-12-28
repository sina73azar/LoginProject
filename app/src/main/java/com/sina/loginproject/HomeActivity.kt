package com.sina.loginproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sina.loginproject.db.User
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
       // val currentUser=intent.getParcelableExtra<User>("currentUser")
        //get curUser from intent coming from CreateAccountActivity
        val curUser:User?
        curUser = if (intent.getStringExtra("created") != null) {
            //coming from create activity
            val userInBundle = intent.getBundleExtra("curUser")
            userInBundle?.getParcelable("curUser")
        } else {
            //comming from login activity
            intent.getParcelableExtra("currentUser")
        }

        tvShowCurrentUser.text="""
            Email: ${curUser?.emailAddress}
            Password: ${curUser?.password}
        """.trimIndent()
    }
}