package com.example.equilizerdesign

import android.os.Parcelable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.parcelize.Parcelize

//savedStateHandle["state"] = savedStateHandle.get<UiState>("state")?.copy(
//sliderFiveValue = event.value
//)
class EqualizerViewModel(
    private val savedStateHandle : SavedStateHandle
): ViewModel() {
//    var uiState by mutableStateOf(UiState())
val uiState = savedStateHandle.getStateFlow("state",UiState() )
    fun onEvent(event : UiEvents){
        when(event){
            is UiEvents.AdjustingSliderFive -> {
                savedStateHandle["state"] = savedStateHandle.get<UiState>("state")?.copy(
                    sliderFiveValue = event.value
                )
            }
            is UiEvents.AdjustingSliderFour ->{
                savedStateHandle["state"] = savedStateHandle.get<UiState>("state")?.copy(
                    sliderFourValue = event.value
                )
            }
            is UiEvents.AdjustingSliderOne -> {
                savedStateHandle["state"] = savedStateHandle.get<UiState>("state")?.copy(
                    sliderOneValue = event.value
                )
            }
            is UiEvents.AdjustingSliderThree -> {
                savedStateHandle["state"] = savedStateHandle.get<UiState>("state")?.copy(
                    sliderThreeValue = event.value
                )
            }
            is UiEvents.AdjustingSliderTwo -> {
                savedStateHandle["state"] = savedStateHandle.get<UiState>("state")?.copy(
                    sliderTwoValue = event.value
                )
            }
        }

    }
}

@Parcelize
data class UiState(
    val sliderOneValue : Float = 0f,
    val sliderTwoValue : Float = 0f,
    val sliderThreeValue : Float = 0f,
    val sliderFourValue : Float = 0f,
    val sliderFiveValue : Float = 0f,
) : Parcelable