package com.droid.code.handlerThread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.droid.code.databinding.ActivityHandlerThreadBinding
import com.droid.code.handlerThread.workers.HandlerOne
import com.droid.code.handlerThread.workers.HandlerThree
import com.droid.code.handlerThread.workers.HandlerTwo

class HandlerThreadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHandlerThreadBinding

    private lateinit var handlerOne : HandlerOne
    private lateinit var handlerTwo : HandlerTwo
    private lateinit var handlerThree : HandlerThree

    init { startThreads() }

    private val mainThreadHandler = object:  Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            // ---> Here the UI thread is updated
            binding.txtDisplayId.text = msg.obj as String?
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHandlerThreadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPublishOneId.setOnClickListener {
            handlerOne.execute {
                val messageToSend = "Message-1"
                val time = 1000L
                sendMessage(data = messageToSend,delay = time)
            }
        }

        binding.btnPublishTwoId.setOnClickListener {
            handlerTwo.execute {
                val messageToSend = "Message-2"
                val time = 2000L
                sendMessage(messageToSend,delay = time)
            }
        }

        binding.btnPublishThreeId.setOnClickListener {
            handlerThree.execute {
                val messageToSend = "Message-3"
                val time = 3000L
                sendMessage(messageToSend,delay = time)
            }
        }

        binding.btnStopThreadId.setOnClickListener { stopThreads() }
        binding.btnRestartThreadId.setOnClickListener { startThreads() }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopThreads()
    }

    /**
     * Starting thread
     */
    private fun startThreads() {
        handlerOne = HandlerOne(HandlerOne::class.java.name)
        handlerTwo = HandlerTwo(HandlerTwo::class.java.name)
        handlerThree = HandlerThree(HandlerThree::class.java.name)
    }

    /**
     * Stopping thread
     */
    private fun stopThreads() {
        handlerOne.stopThread();
        handlerTwo.stopThread();
        handlerThree.stopThread();
    }

    private fun sendMessage(data: String, delay: Long) {
        try {
            // <-----> Perform a time consuming operation <----->
            Thread.sleep(delay)
            // <-----> Perform a time consuming operation <----->

            // <-----> Wrap the data <----->
            val msgToSend = Message.obtain()
            msgToSend.obj = data
            // <-----> Wrap the data <----->

            // Publish to main thread
            mainThreadHandler.sendMessage(msgToSend)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}