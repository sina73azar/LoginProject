package com.sina.loginproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.sina.loginproject.db.MyRoomDb
import com.sina.loginproject.db.User
import com.sina.loginproject.db.UserDao
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
     private val TAG="LoginActivity"
    lateinit var dao: UserDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dao=MyRoomDb.getDatabase(this)!!.getUserDao()
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
            if (!isAccountAvailable(email)) {
                Toast.makeText(this, "There is no account...create one", Toast.LENGTH_SHORT).show()
            } else {
                if (!isPassWordCorrect(mUser)) {
                    Toast.makeText(this, "password incorrect", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val intent=Intent(this,HomeActivity::class.java)
                //send user object via intent
                intent.putExtra("currentUser",mUser)
                startActivity(intent)
            }

            Log.e(TAG, "onCreate: after both was empty for test")
        }
        tvCreateAccount.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isPassWordCorrect(mUser: User): Boolean {
        val correctPass= mUser.emailAddress?.let { dao.getPassWithEmail(it) }
        return mUser.password==correctPass
    }

    private fun isAccountAvailable(email: String): Boolean {
        //search in database via user.email
        val emails=dao.getAllEmails()
        for (item in emails) {
            if (email == item) {
                return true
            }
        }

        return false
    }
}