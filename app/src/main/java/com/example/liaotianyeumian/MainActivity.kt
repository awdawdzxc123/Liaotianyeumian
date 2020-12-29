package com.example.liaotianyeumian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.mas_shang.*
import kotlinx.android.synthetic.main.mas_xia.*

class MainActivity : AppCompatActivity() {
    private var msgDataList = ArrayList<Msg>()
    private lateinit var adapter: MsgAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()//标题弃掉
        initMsg()
        fanhui.setOnClickListener {
            val intent = Intent(this,WeinxinActivity::class.java)
            startActivity(intent)
        }
        if (!::adapter.isInitialized) {
            adapter = MsgAdapter(msgDataList)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        //为适配器添加缩放动画
        val adapter1 = ScaleInAnimationAdapter(adapter).apply {
            //设置动画时长
            setDuration(500)
            //设置动画重复
//            setFirstOnly(false)
        }
        //
        val adapter2: AlphaInAnimationAdapter = AlphaInAnimationAdapter(adapter1).apply {
            setDuration(300)
//            setFirstOnly(false)
        }
        //将数据适配器设置到控件上
        recyclerView.adapter = adapter2
        recyclerView.scrollToPosition(msgDataList.size - 1)

        msgSend.setOnClickListener {
            val text: String = msgText.text.toString()
            if (text.isNotEmpty()) {
                //增加数据到数据源
                val list = adapter.getList()
                if (msgDataList.size != list.size) msgDataList = list as ArrayList<Msg>
                msgDataList.add(Msg(text, 1, R.drawable.img_5))
                //通知适配器增加了数据
                adapter2.notifyItemInserted(msgDataList.size - 1)
                //滚动到最新数据的位置上
                recyclerView.scrollToPosition(msgDataList.size - 1)
                //清空输入框中的内容
                msgText.setText("")
            }
        }

        rootLayout.addOnLayoutChangeListener { _, _, _, _, bottom, _, _, _, oldBottom ->
            if (oldBottom != -1 && oldBottom > bottom) {
                recyclerView.requestLayout()
                recyclerView.post { recyclerView.scrollToPosition(msgDataList.size - 1) }
            }
        }

    }

    private fun initMsg() {
        repeat(1)
        {
            msgDataList.add(
                Msg(
                    "今晚出去吃饭!",
                    0,
                    R.drawable.img_1
                )
            )
        }
    }
}
