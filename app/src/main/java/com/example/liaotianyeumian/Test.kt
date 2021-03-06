package com.example.liaotianyeumian

import java.lang.Exception

//密封类的演示
sealed class Result
class Success(val msg:String):Result()
class Failure(val error:Exception):Result()
class Unknown(val Unknown:Exception):Result()

fun getResultMsg(result: Result)=when(result){
        is Success ->result.msg
        is Failure ->result.error
        is Unknown ->result.Unknown

}
