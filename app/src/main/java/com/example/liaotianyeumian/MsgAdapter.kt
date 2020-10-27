package com.example.liaotianyeumian

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalArgumentException


class MsgAdapter(private var msgList: List<Msg>):
    RecyclerView.Adapter<MsgViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
            if (viewType==Msg.TYPE_LEFT){
                val view:View =LayoutInflater.from(parent.context).inflate(R.layout.mas_left,parent,false)
                LeftViewHolder(view)
            }else{
                val view=LayoutInflater.from(parent.context).inflate(R.layout.mas_right,parent,false)

                val  rightViewHolder =RightViewHolder(view)
                rightViewHolder.itemView.setOnLongClickListener {
                    //移除数据源中的该项
                    msgList -=msgList[rightViewHolder.adapterPosition]
                    //从列表控件中移除该项
                    notifyItemRemoved(rightViewHolder.adapterPosition)

                    true

                }
//                RightViewHolder(view).itemView.setOnLongClickListener {
//                 Log.i("测试","点击事件")
//                    false
//                }
                rightViewHolder
            }


    override fun getItemViewType(position: Int): Int {
        val msg=msgList[position]
        return msg.type

    }

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgList[position]
        when (holder) {
            is LeftViewHolder -> holder.leftMsg.text = msg.content
            is RightViewHolder -> holder.rightMsg.text = msg.content
            else -> throw IllegalArgumentException()
        }
        when (holder) {
            is LeftViewHolder -> holder.leftCun.setImageResource(msg.cun)
            is RightViewHolder -> holder.rightCun.setImageResource(msg.cun)
            else -> throw IllegalArgumentException()
        }
    }
    override  fun  getItemCount() =msgList.size
    fun  getList() =msgList
}