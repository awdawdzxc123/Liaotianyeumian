package com.example.liaotianyeumian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android_weixin.WeinxinActivity
import kotlinx.android.synthetic.main.activity_denglumima.*


class Denglumima : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_denglumima)
        supportActionBar?.hide()//标题弃掉
        Login_butoon.setOnClickListener {
            val id  = edit_phone.text.trim().toString()
            val pwd = edit_Pwd.text.trim().toString()
            if (id == "" || pwd == "")
            {
                Toast.makeText(this,"请输入账号或密码",Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this,WeinxinActivity ::class.java)
                startActivity(intent)
            }
        }
    }
}