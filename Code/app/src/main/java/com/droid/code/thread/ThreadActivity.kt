package com.droid.code.thread

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityThreadBinding
import com.droid.code.thread.workers.CustomThreadOne
import com.droid.code.thread.workers.CustomThreadThree
import com.droid.code.thread.workers.CustomThreadTwo

val TAG_SASUKE = "Sasuke"

class ThreadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThreadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPublishOneId.setOnClickListener {
            val thread = CustomThreadOne()
            thread.name = CustomThreadOne::class.java.name;
            thread.start()
        }

        binding.btnPublishTwoId.setOnClickListener {
            val thread = CustomThreadTwo()
            thread.name = CustomThreadTwo::class.java.name;
            thread.start()
        }

        binding.btnPublishThreeId.setOnClickListener {
            val thread = CustomThreadThree()
            thread.name = CustomThreadThree::class.java.name;
            thread.start()
        }

        // binding.btnStopThreadId.setOnClickListener { stopThreads() }
        // binding.btnRestartThreadId.setOnClickListener { startThreads() }
    }

}