package com.droid.code.runnable.workers

import com.droid.code.runnable.TAG_NARUTO
import com.droid.code.thread.TAG_SASUKE

class CustomRunnableOne : Runnable {

    override fun run() {
        try {
            val TAG_ONE = "one"
            for (i in 0 until 5) {
                Thread.sleep(500L)
                println(TAG_NARUTO.plus("--$i--").plus("Current Runnable-->$TAG_ONE"))
            }
        }catch (ex:InterruptedException){
            println(TAG_NARUTO.plus("--")
                .plus("Runnable named")
                .plus("--")
                .plus(CustomRunnableOne::class.java.name)
                .plus("--")
                .plus("is interrupted"))
        }
    }

}