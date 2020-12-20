package com.example.ninepatchdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.liaotianyeumian.Denglumima
import com.example.liaotianyeumian.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()//标题弃掉
        loginButton.setOnClickListener {
            val intent = Intent(this,Denglumima::class.java)
            startActivity(intent)
        }
    }
}