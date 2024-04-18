package com.dagger.chat.di.component

import android.content.Context
import com.dagger.multimodulwithhilt.component.TimeDependencies
import com.dagger.multimodulwithhilt.utils.DarkThemeUtil
import com.dagger.multimodulwithhilt.utils.ThemeUtil
import com.dagger.multimodulwithhilt.utils.TimeHelper
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [TimeDependencies::class]
)
interface TimeComponent {
    fun timeHelper(): TimeHelper
    fun themeUtil(): ThemeUtil

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(loginModuleDependencies: TimeDependencies): Builder
        fun build(): TimeComponent
    }
}