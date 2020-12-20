package com.example.liaotianyeumian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_wallet.*
import kotlinx.android.synthetic.main.activity_weixin.*

class Wallet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)
        supportActionBar?.hide()//标题弃掉
        imageView18.setOnClickListener {
            val intent = Intent(this,my::class.java)
            startActivity(intent)
        }
    }
}