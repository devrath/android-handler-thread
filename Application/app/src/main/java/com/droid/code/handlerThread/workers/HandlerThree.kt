package com.droid.code.handlerThread.workers

import android.os.Handler
import android.os.HandlerThread

class HandlerThree(handlerTag: String) : HandlerThread(handlerTag) {

    private lateinit var handler : Handler

    init {
        start()
        handler = Handler(looper)
    }

    fun execute( runnable: Runnable) : HandlerThree {
        handler.post(runnable)
        return this@HandlerThree
    }

    fun stopThread() {
        handler.removeCallbacksAndMessages(null);
        handler.looper.quit();
    }

}