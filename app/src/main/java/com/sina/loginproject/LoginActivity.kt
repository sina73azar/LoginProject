package com.sina.loginproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
     private val TAG="LoginActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {

            val email = et_email.text.toString()
            val password = et_password.text.toString()
            //check if email or password is empty
            if (email == "" || password == "") {
                Toast.makeText(this, "Email or Password is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val mUser = User(email, password)
            //check if there is account such this
            if (!isAccountAvailable(mUser)) {
                Toast.makeText(this, "There is no account...create one", Toast.LENGTH_SHORT).show()
            } else {
                val intent=Intent(this,HomeActivity::class.java)
                //send user object via intent
                intent.putExtra("currentUser",mUser)
                startActivity(intent)
            }

            Log.e(TAG, "onCreate: after both was empty for test")
        }
        tvCreateAccount.setOnClickListener {
            val intent = Intent(this, CreateAcountActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isAccountAvailable(user: User): Boolean {
        //search in database via user.email


        return false
    }
}