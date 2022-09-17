package com.droid.code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.droid.code.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val worker : Worker = Worker("Worker")

    val handler = object:  Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            binding.txtDisplayId.text = msg.obj as String?
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPublishOneId.setOnClickListener {
            worker.execute { sendMessage("Message-1") }
        }

        binding.btnPublishTwoId.setOnClickListener {
            worker.execute { sendMessage("Message-2") }
        }

        binding.btnPublishThreeId.setOnClickListener {
            worker.execute { sendMessage("Message-3") }
        }

    }

    private fun sendMessage(data: String) {
        try {
            Thread.sleep(1500)
            val msgToSend = Message.obtain()
            msgToSend.obj = data
            handler.sendMessage(msgToSend)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}