package com.dagger.chat.di.component

import com.dagger.chat.di.module.AnalyticModule
import com.dagger.chat.utils.ChatAnalytics
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [AnalyticModule::class]
)
@Singleton
interface AnalyticsComponent {
    fun chatAnalytic(): ChatAnalytics
}