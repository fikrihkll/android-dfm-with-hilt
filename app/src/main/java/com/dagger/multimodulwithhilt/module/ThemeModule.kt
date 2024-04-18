package com.dagger.multimodulwithhilt.module

import com.dagger.multimodulwithhilt.utils.DarkThemeUtil
import com.dagger.multimodulwithhilt.utils.ThemeUtil
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ThemeModule {

    @Binds
    fun provideImageUtil(darkThemeUtil: DarkThemeUtil): ThemeUtil

}