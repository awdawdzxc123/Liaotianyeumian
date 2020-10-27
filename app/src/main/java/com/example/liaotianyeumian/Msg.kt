package com.example.liaotianyeumian

class Msg(val content:String, val type:Int, val cun:Int) {
    companion object{
        const val TYPE_LEFT=0
        const val TYPE_RIGHT=1

    }
}