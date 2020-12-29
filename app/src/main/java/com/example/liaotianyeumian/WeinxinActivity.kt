package com.example.liaotianyeumian

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.android_weixin.Fruit
import com.example.android_weixin.FruitAdapter
import kotlinx.android.synthetic.main.activity_weixin.*
import kotlin.collections.ArrayList
class WeinxinActivity : AppCompatActivity() {

    //    private val data= listOf("苹果","香蕉","哈密瓜","月饼","山竹","西瓜","榴莲","水蜜桃","葡萄","荔枝","火龙果","小可爱","芒果")
    private  val fruitList=ArrayList<Fruit>()

    private fun initFruits(){
        repeat(1){
            fruitList.add(Fruit("c8-601","你好靓仔啊", R.drawable.weini))
            fruitList.add(Fruit("护发之团","姜块护发", R.drawable.hufa))
            fruitList.add(Fruit("19级移动","嗷嗷嗷", R.drawable.img_4))
            fruitList.add(Fruit("19白云学院","白云学院群", R.drawable.img_3))
            fruitList.add(Fruit("美团抢卷","抢卷群",R.drawable.img_6))
            fruitList.add(Fruit("19白云学院","19白云群", R.drawable.img_7))
            fruitList.add(Fruit("19饿了吗","饿了吗群",R.drawable.wode))
            fruitList.add(Fruit("VIP小区","撩妹群",R.drawable.dian))
            fruitList.add(Fruit("白云学院","泡妞群", R.drawable.img_0))
            fruitList.add(Fruit("不锈钢大队","撩妹群",R.drawable.jia))
            fruitList.add(Fruit("钢t大队","撩妹群",R.drawable.gobo))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weixin)
        supportActionBar?.hide()//标题弃掉
        fullScreen(this)
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        faxian.setOnClickListener {
            val intent = Intent(this,find::class.java)
            startActivity(intent)
        }
        imageView15.setOnClickListener {
            val intent = Intent(this,my::class.java)
            startActivity(intent)
        }
        imageView3.setOnClickListener {
            val intent = Intent(this,com.example.liaotianyeumian.Wechat_Moments::class.java)
            startActivity(intent)
        }
        txlu.setOnClickListener {
            val intent = Intent(this,Tongxilu::class.java)
            startActivity(intent)
        }
        initFruits()

        //上下文,列表子视图,数据源
//        val adapter =ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,data)

        val fruitAdapter= FruitAdapter(this,R.layout.weixin,fruitList)
        //绑定到控件
//        listViewTest.adapter=adapter;

        listViewTest.adapter=fruitAdapter;
        val manager =getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager
        //兼容性判断
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            //创建通知渠道,参数:id,通知渠道的名称,通知的重要等级(默认等级,高优先级,底忧先级)
            val channel = NotificationChannel("normal","测试通道", NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel)
        }

        //创建通知,参数:通知渠道id
        val notification = NotificationCompat.Builder(this,"normal")
            .setContentTitle("微信到账1000万元")
            .setContentText("")
            .setSmallIcon(R.drawable.weini)
            .setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.weini))
            .build()
        //发出通知
        manager.notify(1,notification)

        listViewTest.setOnItemClickListener { _,_, i, _->
            val fruit =fruitList[i]
            Toast.makeText(this,fruit.name,Toast.LENGTH_SHORT).show()
            val intent =Intent(this,MainActivity::class.java)
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
