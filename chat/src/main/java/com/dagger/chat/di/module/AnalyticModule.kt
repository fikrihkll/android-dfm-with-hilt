package com.dagger.chat.di.module

import com.dagger.chat.utils.ChatAnalytics
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AnalyticModule {

    @Provides
    @Singleton
    fun provideChatAnalytic(): ChatAnalytics = ChatAnalytics()

}