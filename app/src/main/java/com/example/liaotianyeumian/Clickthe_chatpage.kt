package com.example.liaotianyeumian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_clickthe_chatpage.*

class Clickthe_chatpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clickthe_chatpage)
        supportActionBar?.hide()//标题弃掉

        button_tuichu.setOnClickListener {
            val intent = Intent(this,Denglumima::class.java)
            startActivity(intent)
        }
    }
}