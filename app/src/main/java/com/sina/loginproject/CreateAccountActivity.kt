package com.sina.loginproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.LayoutDirection
import android.view.Menu
import android.view.MenuItem
import android.view.View.LAYOUT_DIRECTION_LTR
import kotlinx.android.synthetic.main.activity_create_acount.*

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_acount)

        setSupportActionBar(createAccountToolbar)
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