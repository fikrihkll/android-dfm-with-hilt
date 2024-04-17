package com.dagger.multimodulwithhilt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dagger.multimodulwithhilt.databinding.ActivityMainBinding
import com.dagger.multimodulwithhilt.utils.TimeHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var timeHelper: TimeHelper

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        timeHelper.extendTime(MainActivity::class.simpleName.toString())

        binding.textViewHelloWorld.setOnClickListener {
            startActivity(Intent(this, Class.forName("com.dagger.chat.ChatActivity")))
        }
    }
}