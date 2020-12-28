package com.sina.loginproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.LayoutDirection
import android.view.Menu
import android.view.MenuItem
import android.view.View.LAYOUT_DIRECTION_LTR
import android.widget.Toast
import com.sina.loginproject.db.MyRoomDb
import com.sina.loginproject.db.User
import com.sina.loginproject.db.UserDao
import kotlinx.android.synthetic.main.activity_create_acount.*

class CreateAccountActivity : AppCompatActivity() {

    lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_acount)
        userDao = MyRoomDb.getDatabase(this)!!.getUserDao()
        setSupportActionBar(createAccountToolbar)
        val intent=Intent(this,HomeActivity::class.java)
        btnCreateAccount.setOnClickListener {

            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val myUser = User(email, password)
            userDao.insertUser(myUser)
            Toast.makeText(this, "$email is successfully created", Toast.LENGTH_SHORT).show()
            val bundle = Bundle()
            bundle.putParcelable("curUser",myUser)
            intent.putExtra("curUser",bundle)
            intent.putExtra("created","just_created")
            startActivity(intent)
        }
    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//
//        menuInflater.inflate(R.menu.main,menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
////        when (item.itemId) {
////            R.id.back_for_menu->finish()
////        }
//        return super.onOptionsItemSelected(item)
//    }
}