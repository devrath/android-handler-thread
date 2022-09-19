package com.droid.code.handler.workers

import com.droid.code.handler.TAG_SAKURA
import com.droid.code.runnable.TAG_NARUTO
import com.droid.code.runnable.workers.CustomRunnableOne

class RunnableWorkOne : Runnable {

    override fun run() {
        try {
            val TAG_ONE = "one"
            for (i in 0 until 5) {
                Thread.sleep(500L)
                println(TAG_SAKURA.plus("--$i--").plus("Current Runnable-->$TAG_ONE"))
            }
        }catch (ex:InterruptedException){
            println(
                TAG_SAKURA.plus("--")
                .plus("Runnable named")
                .plus("--")
                .plus(CustomRunnableOne::class.java.name)
                .plus("--")
                .plus("is interrupted"))
        }
    }

}