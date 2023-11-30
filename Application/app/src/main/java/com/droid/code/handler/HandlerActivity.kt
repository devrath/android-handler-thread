package com.droid.code.handler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityHandlerBinding
import com.droid.code.handler.workers.RunnableWorkOne
import com.droid.code.handler.workers.RunnableWorkThree
import com.droid.code.handler.workers.RunnableWorkTwo
import com.droid.code.runnable.workers.CustomRunnableOne
import com.droid.code.runnable.workers.CustomRunnableThree
import com.droid.code.runnable.workers.CustomRunnableTwo

val TAG_SAKURA = "Sakura"

class HandlerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHandlerBinding
    lateinit var bkgThread : CustomBackgroundThread

    lateinit var  runnableWorkOne : Runnable
    lateinit var  runnableWorkTwo : Runnable
    lateinit var  runnableWorkThree : Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHandlerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startThread()

        binding.btnPublishOneId.setOnClickListener {
            runnableWorkOne = RunnableWorkOne()
            bkgThread.addTaskToMessageQueue(runnableWorkOne);
        }

        binding.btnPublishTwoId.setOnClickListener {
            runnableWorkTwo = RunnableWorkTwo()
            bkgThread.addTaskToMessageQueue(runnableWorkTwo);
        }

        binding.btnPublishThreeId.setOnClickListener {
            runnableWorkThree = RunnableWorkThree()
            bkgThread.addTaskToMessageQueue(runnableWorkThree);
        }

        binding.btnRestartThreadId.setOnClickListener {
            startThread()
        }

        binding.btnStopThreadId.setOnClickListener {
            stopThreads()
        }

    }

    private fun startThread() {
        bkgThread = CustomBackgroundThread()
        bkgThread.start() // Start a new thread
    }

    private fun stopThreads() {
        bkgThread.stopTheThread()
    }

}