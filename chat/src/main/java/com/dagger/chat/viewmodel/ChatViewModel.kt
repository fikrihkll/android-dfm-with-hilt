package com.dagger.chat.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dagger.chat.utils.ChatAnalytics
import com.dagger.chat.utils.ImageUtil
import com.dagger.multimodulwithhilt.utils.ThemeUtil
import com.dagger.multimodulwithhilt.utils.TimeHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChatViewModel
@Inject
constructor(
    analytics: ChatAnalytics,
    imageUtil: ImageUtil,
    timeUtils: TimeHelper,
    themeUtil: ThemeUtil
): ViewModel() {



    private val _dataStateFlow: MutableStateFlow<Int> = MutableStateFlow(0)
    val dataStateFlow: StateFlow<Int> = _dataStateFlow.asStateFlow()

    fun start() {
        viewModelScope.launch {
            _dataStateFlow.emit(_dataStateFlow.value + 1)
        }
    }

}