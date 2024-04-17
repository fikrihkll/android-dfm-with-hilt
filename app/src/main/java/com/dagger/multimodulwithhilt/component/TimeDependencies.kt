package com.dagger.multimodulwithhilt.component

import com.dagger.multimodulwithhilt.utils.TimeHelper
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface TimeDependencies {
    fun timeHelper(): TimeHelper
}