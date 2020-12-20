package com.example.android_weixin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.liaotianyeumian.*
import kotlinx.android.synthetic.main.activity_my.*
import kotlinx.android.synthetic.main.activity_weixin.*
import kotlin.collections.ArrayList
class WeinxinActivity : AppCompatActivity() {

    //    private val data= listOf("苹果","香蕉","哈密瓜","月饼","山竹","西瓜","榴莲","水蜜桃","葡萄","荔枝","火龙果","小可爱","芒果")
    private  val fruitList=ArrayList<Fruit>()

    private fun initFruits(){
        repeat(1){
            fruitList.add(Fruit("19篮球队","打球群", R.drawable.gobo))
            fruitList.add(Fruit("护发之团","护发群", R.drawable.hufa))
            fruitList.add(Fruit("19级移动","19群", R.drawable.img_4))
            fruitList.add(Fruit("C8-601","撩妹群",R.drawable.img_2))
            fruitList.add(Fruit("19白云学院","白云学院群", R.drawable.img_3))
            fruitList.add(Fruit("美团抢卷","抢卷群",R.drawable.img_6))
            fruitList.add(Fruit("19白云学院","19白云群", R.drawable.img_7))
            fruitList.add(Fruit("19饿了吗","饿了吗群",R.drawable.wen))
            fruitList.add(Fruit("VIP小区","撩妹群",R.drawable.dian))
            fruitList.add(Fruit("白云学院","泡妞群", R.drawable.img_0))
            fruitList.add(Fruit("不锈钢大队","撩妹群",R.drawable.jia))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weixin)
        supportActionBar?.hide()//标题弃掉
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


        listViewTest.setOnItemClickListener { _,_, i, _->
            val fruit =fruitList[i]
            Toast.makeText(this,fruit.name,Toast.LENGTH_SHORT).show()
            val intent =Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
