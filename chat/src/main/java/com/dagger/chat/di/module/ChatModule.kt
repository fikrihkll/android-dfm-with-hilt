package com.dagger.chat.di.module

import com.dagger.chat.utils.ImageUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class ChatModule {

    @Provides
    @ActivityScoped
    fun provideImageUtil(): ImageUtil {
        return ImageUtil()
    }

}