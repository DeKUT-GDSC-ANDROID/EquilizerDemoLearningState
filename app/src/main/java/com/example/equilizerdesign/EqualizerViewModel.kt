package com.example.equilizerdesign

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class EqualizerViewModel: ViewModel() {
    var uiState by mutableStateOf(UiState())

    fun onEvent(event : UiEvents){
        when(event){
            is UiEvents.AdjustingSliderFive -> {
                uiState = uiState.copy(
                    sliderFiveValue = event.value
                )
            }
            is UiEvents.AdjustingSliderFour ->{
                uiState = uiState.copy(
                    sliderFourValue = event.value
                )
            }
            is UiEvents.AdjustingSliderOne -> {
                uiState = uiState.copy(
                    sliderOneValue = event.value
                )
            }
            is UiEvents.AdjustingSliderThree -> {
                uiState = uiState.copy(
                    sliderThreeValue = event.value
                )
            }
            is UiEvents.AdjustingSliderTwo -> {
                uiState = uiState.copy(
                    sliderTwoValue = event.value
                )
            }
        }

    }
}

data class UiState(
    val sliderOneValue : Float = 0f,
    val sliderTwoValue : Float = 0f,
    val sliderThreeValue : Float = 0f,
    val sliderFourValue : Float = 0f,
    val sliderFiveValue : Float = 0f,
)