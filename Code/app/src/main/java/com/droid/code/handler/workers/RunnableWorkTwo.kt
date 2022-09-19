package com.droid.code.handler.workers

import com.droid.code.handler.TAG_SAKURA
import com.droid.code.runnable.TAG_NARUTO
import com.droid.code.runnable.workers.CustomRunnableTwo

class RunnableWorkTwo   : Runnable {

    override fun run() {
        try {
            val TAG_TWO = "two"
            for (i in 0 until 5) {
                Thread.sleep(500L)
                println(TAG_SAKURA.plus("--$i--").plus("Current Runnable-->$TAG_TWO"))
            }
        }catch (ex:InterruptedException){
            println(
                TAG_SAKURA.plus("--")
                .plus("Runnable named")
                .plus("--")
                .plus(CustomRunnableTwo::class.java.name)
                .plus("--")
                .plus("is interrupted"))
        }
    }

}