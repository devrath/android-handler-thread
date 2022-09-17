package com.droid.code.runnable.workers

import com.droid.code.runnable.TAG_NARUTO

class CustomRunnableThree  : Runnable {

    override fun run() {
        try {
            val TAG_THREE = "three"
            for (i in 0 until 5) {
                Thread.sleep(500L)
                println(TAG_NARUTO.plus("--$i--").plus("Current Runnable-->$TAG_THREE"))
            }
        }catch (ex:InterruptedException){
            println(TAG_NARUTO.plus("--")
                .plus("Runnable named")
                .plus("--")
                .plus(CustomRunnableThree::class.java.name)
                .plus("--")
                .plus("is interrupted"))
        }
    }

}