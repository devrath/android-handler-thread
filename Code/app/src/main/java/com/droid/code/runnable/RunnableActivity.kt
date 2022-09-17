package com.droid.code.runnable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityRunnableBinding

class RunnableActivity  : AppCompatActivity() {

    val TAG = "Naruto"

    private lateinit var binding: ActivityRunnableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRunnableBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnPublishOneId.setOnClickListener {
            val thread1 = Thread(runnable1)
            thread1.start()
        }

        binding.btnPublishTwoId.setOnClickListener {
            val thread2 = Thread(runnable2)
            thread2.start()
        }

        binding.btnPublishThreeId.setOnClickListener {
            val thread3 = Thread(runnable3)
            thread3.start()
        }

    }


    private val runnable1 = Runnable {
        val TAG_ONE = "one"
        for (i in 0 until 5) {
            Thread.sleep(500L)
            println(TAG.plus("--$i--").plus("Current Runnable-->$TAG_ONE"))
        }
    }

    private val runnable2 = Runnable {
        val TAG_TWO = "two"
        for (i in 0 until 5) {
            Thread.sleep(500L)
            println(TAG.plus("--$i--").plus("Current Runnable-->$TAG_TWO"))
        }
    }

    private val runnable3 = Runnable {
        val TAG_THREE = "three"
        for (i in 0 until 5) {
            Thread.sleep(500L)
            println(TAG.plus("--$i--").plus("Current Runnable-->$TAG_THREE"))
        }
    }

}