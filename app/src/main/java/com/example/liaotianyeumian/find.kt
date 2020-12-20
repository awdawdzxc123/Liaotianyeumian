package com.example.liaotianyeumian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_weixin.WeinxinActivity
import kotlinx.android.synthetic.main.activity_find.*
import kotlinx.android.synthetic.main.activity_my.*

import kotlinx.android.synthetic.main.activity_weixin.imageView15
import kotlinx.android.synthetic.main.activity_weixin.xinx

class find : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find)
        supportActionBar?.hide()//标题弃掉
        sousu.setOnClickListener {
            val intent = Intent(this,com.example.liaotianyeumian.Wechat_Moments::class.java)
            startActivity(intent)
        }
        imageView13.setOnClickListener {
            val intent = Intent(this, WeinxinActivity::class.java)
            startActivity(intent)
        }
        imageView15.setOnClickListener {
            val intent = Intent(this,my::class.java)
            startActivity(intent)
        }
        imageView12.setOnClickListener {
            val intent = Intent(this,Tongxilu::class.java)
            startActivity(intent)
        }
    }
}