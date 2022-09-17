package com.droid.code.handler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityHandlerBinding
import com.droid.code.databinding.ActivitySelectionBinding

class HandlerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHandlerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHandlerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}