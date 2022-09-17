package com.droid.code.workers

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


}