package com.rvcoding.mygasmix.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rvcoding.mygasmix.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn


class MyGasViewModel : ViewModel() {

    val splashImages = flow<Int> {
        val images = listOf(
            R.drawable.splash,
            R.drawable.splash2,
            R.drawable.splash3,
            R.drawable.splash4,
            R.drawable.splash5,
        )
        emit(images[0])
        var currentIndex = 1

        while (true) {
            delay(5_000L)
            emit(images[currentIndex])
            if (currentIndex == images.size - 1) {
                currentIndex = 0
            } else {
                currentIndex++
            }
        }
    }
        .flowOn(Dispatchers.IO)
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            R.drawable.splash
        )

}