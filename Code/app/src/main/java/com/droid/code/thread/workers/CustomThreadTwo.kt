package com.droid.code.thread.workers

import com.droid.code.thread.TAG_SASUKE

class CustomThreadTwo : Thread() {
    override fun run() {
        try {
            val TAG_TWO = "two"
            for (i in 0 until 5) {
                Thread.sleep(500L)
                println(TAG_SASUKE.plus("--$i--").plus(name).plus("--").plus(TAG_TWO))
            }
        }catch (ex:InterruptedException){
            println(TAG_SASUKE.plus("--").plus("Thread named").plus("--").plus(name).plus("--").plus("is interrupted"))
        }
    }
}