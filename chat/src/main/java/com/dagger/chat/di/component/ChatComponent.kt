package com.dagger.chat.di.component

import com.dagger.chat.ChatActivity
import com.dagger.chat.di.module.ChatModule
import com.dagger.chat.di.module.ViewModelModule
import dagger.Component
import dagger.hilt.android.scopes.ActivityScoped

@Component(
    dependencies = [TimeComponent::class, AnalyticsComponent::class],
    modules = [ChatModule::class, ViewModelModule::class]
)
@ActivityScoped
interface ChatComponent {
    fun inject(chatActivity: ChatActivity)
}