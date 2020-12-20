package com.example.liaotianyeumian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_weixin.WeinxinActivity
import kotlinx.android.synthetic.main.activity_my.*
import kotlinx.android.synthetic.main.activity_weixin.*

class my : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)

        supportActionBar?.hide()//标题弃掉

        find_fx.setOnClickListener {
            val intent = Intent(this,find::class.java)
            startActivity(intent)
        }
        wei_xin.setOnClickListener {
            val intent = Intent(this,WeinxinActivity::class.java)
            startActivity(intent)
        }
        wechat.setOnClickListener {
            val intent = Intent(this,Tongxilu::class.java)
            startActivity(intent)
        }
        shezhi.setOnClickListener {
            val intent = Intent(this,Clickthe_chatpage::class.java)
            startActivity(intent)
        }
        zhifu.setOnClickListener {
            val intent = Intent(this,Wallet::class.java)
            startActivity(intent)
        }
    }
}