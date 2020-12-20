package com.example.liaotianyeumian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_weixin.WeinxinActivity
import kotlinx.android.synthetic.main.activity_find.*
import kotlinx.android.synthetic.main.activity_find.imageView15
import kotlinx.android.synthetic.main.activity_weixin.*
import kotlinx.android.synthetic.main.navigation_txl.*

class Tongxilu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tongxilu)
        supportActionBar?.hide()//标题弃掉

        translate.setOnClickListener {
            val intent = Intent(this,com.example.liaotianyeumian.Wechat_Moments::class.java)
            startActivity(intent)
        }
        wx.setOnClickListener {
            val intent = Intent(this, WeinxinActivity::class.java)
            startActivity(intent)
        }
        wo.setOnClickListener {
            val intent = Intent(this,my::class.java)
            startActivity(intent)
        }
        fx.setOnClickListener {
            val intent = Intent(this,find::class.java)
            startActivity(intent)
        }
    }
}