package com.dagger.chat.di.component

import android.content.Context
import com.dagger.multimodulwithhilt.component.TimeDependencies
import com.dagger.multimodulwithhilt.utils.TimeHelper
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [TimeDependencies::class]
)
interface TimeComponent {
    fun timeHelper(): TimeHelper

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(loginModuleDependencies: TimeDependencies): Builder
        fun build(): TimeComponent
    }
}