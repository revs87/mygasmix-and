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

    val splashImages = flow<Pair<Int, Int>> {
        val images = listOf(
            R.drawable.splash,
            R.drawable.splash2,
            R.drawable.splash3,
            R.drawable.splash4,
            R.drawable.splash5,
        )
        emit(Pair(images[0], images[0]))
        var currentIndex = 0

        while (true) {
            delay(6_000L)
            val nextIndex = if (currentIndex == images.size - 1) {
                0
            } else {
                currentIndex + 1
            }
            emit(Pair(images[currentIndex], images[nextIndex]))
            currentIndex = nextIndex
        }
    }
        .flowOn(Dispatchers.IO)
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            Pair(R.drawable.splash, R.drawable.splash)
        )

}