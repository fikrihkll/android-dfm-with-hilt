package com.dagger.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.dagger.chat.di.component.DaggerAnalyticsComponent
import com.dagger.chat.di.component.DaggerChatComponent
import com.dagger.chat.di.component.DaggerTimeComponent
import com.dagger.chat.utils.ChatAnalytics
import com.dagger.chat.viewmodel.ChatViewModel
import com.dagger.chat.viewmodel.ChatViewModelFactory
import com.dagger.multimodulwithhilt.component.TimeDependencies
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChatActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ChatViewModelFactory

    @Inject
    lateinit var analytics: ChatAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val viewModel = ViewModelProvider(this, factory)[ChatViewModel::class.java]
        viewModel.start()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.dataStateFlow.collectLatest {
                    Log.w("FKR", "COUNTER $it")
                }
                Log.w("FKR", "COLLECT FINISH")
            }
        }
    }

    private fun inject() {
        val timeComponent = DaggerTimeComponent
            .builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    TimeDependencies::class.java
                )
            )
            .build()

        val analyticsComponent = DaggerAnalyticsComponent
            .builder()
            .build()

        DaggerChatComponent
            .builder()
            .timeComponent(timeComponent)
            .analyticsComponent(analyticsComponent)
            .build()
            .inject(this)
    }
}