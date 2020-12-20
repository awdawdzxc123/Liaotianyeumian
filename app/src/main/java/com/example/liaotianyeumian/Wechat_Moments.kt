package com.example.liaotianyeumian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_weixin.WeinxinActivity
import kotlinx.android.synthetic.main.activity_wechat__moments.*
import kotlinx.android.synthetic.main.activity_weixin.*

class Wechat_Moments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wechat__moments)
        supportActionBar?.hide()//标题弃掉

        quexiao.setOnClickListener {
            val intent = Intent(this, WeinxinActivity::class.java)
            startActivity(intent)
        }
    }
}