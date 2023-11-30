package com.droid.code.handler

import android.os.Handler
import android.os.Looper




class CustomBackgroundThread : Thread() {

    private var handler: Handler? = null

    override fun run() {
        super.run()
        Looper.prepare() // Prepare the looper and associate with current thread
        handler = Handler()
        Looper.loop() // Start the thread so that it can keep the thread active
    }

    /**
     *  Here we can add the runnable to the message queue
     */
    fun addTaskToMessageQueue(task: Runnable) {
        handler?.post(task)
    }

    fun stopTheThread() { interrupt() }

}