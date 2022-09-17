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

    lateinit var threadOne : CustomThreadOne
    lateinit var threadTwo : CustomThreadTwo
    lateinit var threadThree : CustomThreadThree

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPublishOneId.setOnClickListener {
            threadOne = CustomThreadOne()
            threadOne.name = CustomThreadOne::class.java.name;
            threadOne.start()
        }

        binding.btnPublishTwoId.setOnClickListener {
            threadTwo = CustomThreadTwo()
            threadTwo.name = CustomThreadTwo::class.java.name;
            threadTwo.start()
        }

        binding.btnPublishThreeId.setOnClickListener {
            threadThree = CustomThreadThree()
            threadThree.name = CustomThreadThree::class.java.name;
            threadThree.start()
        }

        binding.btnStopThreadId.setOnClickListener { stopThreads() }
    }

    private fun stopThreads() {
        if(::threadOne.isInitialized){
            threadOne.interrupt()
        }
        if(::threadTwo.isInitialized){
            threadTwo.interrupt()
        }
        if(::threadThree.isInitialized){
            threadThree.interrupt()
        }
    }
}