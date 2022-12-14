package com.droid.code.handlerThread.workers

import android.os.Handler
import android.os.HandlerThread

class HandlerOne(handlerTag: String) : HandlerThread(handlerTag) {

    private lateinit var handler : Handler

    init {
        start()
        handler = Handler(looper)
    }

    fun execute( runnable: Runnable) : HandlerOne {
        handler.post(runnable)
        return this@HandlerOne
    }

    fun stopThread() {
        handler.removeCallbacksAndMessages(null);
        handler.looper.quit();
    }

}