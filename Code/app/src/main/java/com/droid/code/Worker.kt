package com.droid.code

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper

class Worker(handlerTag: String) : HandlerThread(handlerTag) {

    private lateinit var handler : Handler

    init {
        start()
        handler = Handler(looper)
    }

    public fun execute( runnable: Runnable) : Worker {
        handler.post(runnable)
        return this@Worker
    }


}