package com.dagger.chat.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dagger.chat.viewmodel.ChatViewModel
import com.dagger.chat.viewmodel.ChatViewModelFactory
import com.dagger.chat.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.multibindings.IntoMap

@Module
@InstallIn(ActivityComponent::class)
abstract class ViewModelModule {

    @Binds
    @ActivityScoped
    abstract fun bindViewModelFactory(factory: ChatViewModelFactory): ViewModelProvider.Factory

    @Binds
    @ActivityScoped
    @IntoMap
    @ViewModelKey(ChatViewModel::class)
    abstract fun chatViewModel(viewModel: ChatViewModel): ViewModel

}