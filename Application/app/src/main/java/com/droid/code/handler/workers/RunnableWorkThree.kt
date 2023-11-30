package com.droid.code.handler.workers

import com.droid.code.handler.TAG_SAKURA
import com.droid.code.runnable.TAG_NARUTO
import com.droid.code.runnable.workers.CustomRunnableThree

class RunnableWorkThree  : Runnable {

    override fun run() {
        try {
            val TAG_THREE = "three"
            for (i in 0 until 5) {
                Thread.sleep(500L)
                println(TAG_SAKURA.plus("--$i--").plus("Current Runnable-->$TAG_THREE"))
            }
        }catch (ex:InterruptedException){
            println(
                TAG_SAKURA.plus("--")
                .plus("Runnable named")
                .plus("--")
                .plus(CustomRunnableThree::class.java.name)
                .plus("--")
                .plus("is interrupted"))
        }
    }

}