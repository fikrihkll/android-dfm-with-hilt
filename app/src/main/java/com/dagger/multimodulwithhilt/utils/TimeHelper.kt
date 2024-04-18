package com.dagger.multimodulwithhilt.utils

import javax.inject.Inject

class TimeHelper @Inject constructor() {

    fun extendTime(arg: String) {
        println("extended $arg")
    }

}