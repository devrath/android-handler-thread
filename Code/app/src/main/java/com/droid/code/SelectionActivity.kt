package com.droid.code

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityHandlerThreadBinding
import com.droid.code.databinding.ActivitySelectionBinding
import com.droid.code.handler.HandlerActivity
import com.droid.code.handlerThread.HandlerThreadActivity
import com.droid.code.utils.openActivity

class SelectionActivity : AppCompatActivity(){

    private lateinit var binding: ActivitySelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHandlerDemoId.setOnClickListener {
            openActivity(HandlerActivity::class.java)
        }

        binding.btnHandlerThreadDemoId.setOnClickListener {
            openActivity(HandlerThreadActivity::class.java)
        }

    }

}