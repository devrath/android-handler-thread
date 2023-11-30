package com.droid.code.runnable.workers

import com.droid.code.runnable.TAG_NARUTO

class CustomRunnableTwo  : Runnable {

    override fun run() {
        try {
            val TAG_TWO = "two"
            for (i in 0 until 5) {
                Thread.sleep(500L)
                println(TAG_NARUTO.plus("--$i--").plus("Current Runnable-->$TAG_TWO"))
            }
        }catch (ex:InterruptedException){
            println(TAG_NARUTO.plus("--")
                .plus("Runnable named")
                .plus("--")
                .plus(CustomRunnableTwo::class.java.name)
                .plus("--")
                .plus("is interrupted"))
        }
    }

}