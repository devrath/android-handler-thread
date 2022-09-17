package com.droid.code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.droid.code.databinding.ActivityMainBinding
import com.droid.code.workers.HandlerOne
import com.droid.code.workers.HandlerThree
import com.droid.code.workers.HandlerTwo

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val handlerOne = HandlerOne(HandlerOne::class.java.name)
    private val handlerTwo = HandlerTwo(HandlerTwo::class.java.name)
    private val handlerThree = HandlerThree(HandlerThree::class.java.name)

    private val mainThreadHandler = object:  Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            // ---> Here the UI thread is updated
            binding.txtDisplayId.text = msg.obj as String?
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
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