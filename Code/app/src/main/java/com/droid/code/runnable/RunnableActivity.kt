package com.droid.code.runnable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityRunnableBinding
import com.droid.code.runnable.workers.CustomRunnableOne
import com.droid.code.runnable.workers.CustomRunnableThree
import com.droid.code.runnable.workers.CustomRunnableTwo

val TAG_NARUTO = "Naruto"

class RunnableActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityRunnableBinding

    lateinit var  thread1 : Thread
    lateinit var  thread2 : Thread
    lateinit var  thread3 : Thread


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRunnableBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnPublishOneId.setOnClickListener {
            val runnable = CustomRunnableOne()
            thread1 = Thread(runnable)
            thread1.name = CustomRunnableOne::javaClass.name
            thread1.start()
        }

        binding.btnPublishTwoId.setOnClickListener {
            val runnable = CustomRunnableTwo()
            thread2 = Thread(runnable)
            thread2.name = CustomRunnableTwo::javaClass.name
            thread2.start()
        }

        binding.btnPublishThreeId.setOnClickListener {
            val runnable = CustomRunnableThree()
            thread3 = Thread(runnable)
            thread3.name = CustomRunnableThree::javaClass.name
            thread3.start()
        }

        binding.btnStopThreadId.setOnClickListener {
            stopThreads()
        }

    }

    private fun stopThreads() {
        if(::thread1.isInitialized){
            thread1.interrupt()
        }
        if(::thread2.isInitialized){
            thread2.interrupt()
        }
        if(::thread3.isInitialized){
            thread3.interrupt()
        }
    }

}