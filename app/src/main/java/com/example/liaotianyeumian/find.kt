package com.example.liaotianyeumian

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_find.*

import kotlinx.android.synthetic.main.activity_weixin.imageView15

class find : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find)
        supportActionBar?.hide()//标题弃掉

        fullScreen(this)
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
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
    /**
     * 通过设置全屏，设置状态栏透明
     *
     * @param activity
     */
    private fun fullScreen(activity: Activity) {
        run {

            //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
            val window = activity.window
            val decorView = window.decorView
            //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
            val option = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            decorView.systemUiVisibility = option
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }
}