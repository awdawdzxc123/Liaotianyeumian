package com.example.liaotianyeumian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.mas_xia.*

class MainActivity : AppCompatActivity() {

    private var msgDataList =ArrayList<Msg>()
    private  lateinit var adapter: MsgAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  layoutManager =LinearLayoutManager(this)
        recyclerView.layoutManager =layoutManager
        recyclerView.adapter=adapter

        supportActionBar?.hide()//标题弃掉
        initMsg()

        recyclerView.layoutManager=LinearLayoutManager(this)
        if (!::adapter.isInitialized){
        adapter = MsgAdapter(msgDataList)}
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
        recyclerView.adapter=adapter2
        recyclerView.scrollToPosition(msgDataList.size- 1)
        msgSend.setOnClickListener {
            val text:String =msgText.text.toString()
            if (text.isNotEmpty()){
                //增加数据到数据源
                val list =adapter.getList()
                if (msgDataList.size !=list.size)msgDataList =list as ArrayList<Msg>
                    msgDataList.add(Msg(text,1,R.drawable.img_5))
                //通知适配器增加了数据
                adapter2.notifyItemInserted(msgDataList.size-1)
                //滚动到最新数据的位置上
                recyclerView.scrollToPosition(msgDataList.size- 1)
                //清空输入框中的内容
                msgText.setText("")
            }
        }
        rootLayout.addOnLayoutChangeListener { _, _, _, _, bottom, _, _, _, oldBottom ->
            if (oldBottom !=-1 &&oldBottom > bottom){
                recyclerView.requestLayout()
                recyclerView.post { recyclerView.scrollToPosition(msgDataList.size -1) }
            }
        }
    }

    private fun initMsg() {
        repeat(2)
        {
            msgDataList.add(
                Msg(
                    "两个include的高度拉不动1111111111111111111111111122222222222222222222222222222222222",
                    0,
                    R.drawable.img_1
                )
            )
            msgDataList.add(
                Msg(
                    "一直是占满界面",
                    0,
                    R.drawable.img_1
                )
            )
            msgDataList.add(
                Msg(
                    "直接在界面用控件试试",
                    1,
                    R.drawable.img_5
                )
            )
            msgDataList.add(
                Msg(
                    "可以拖了",
                    0,
                    R.drawable.img_1
                )
            )
            msgDataList.add(
                Msg(
                    "啥也没搞，突然又能拖动了。。",
                    0,
                    R.drawable.img_4
                )
            )
            msgDataList.add(
                Msg(
                    "让人怪不好意思的",
                    0,
                    R.drawable.img_7
                )
            )
            msgDataList.add(
                Msg(
                    "为啥一点打字会吃掉一点",
                    0,
                    R.drawable.img_6
                )
            )
            msgDataList.add(
                Msg(
                    "测试看看 下面的区域如果是一个整体，设置一点的Top内边距",
                    1 ,
                     R.drawable.img_5
                )
            )
        }
    }
}
