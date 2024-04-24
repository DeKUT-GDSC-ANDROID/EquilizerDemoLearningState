package com.example.equilizerdesign

sealed class UiEvents {
    data class AdjustingSliderOne(val value : Float) : UiEvents()
    data class AdjustingSliderTwo(val value : Float) : UiEvents()
    data class AdjustingSliderThree(val value : Float) : UiEvents()
    data class AdjustingSliderFour(val value : Float) : UiEvents()
    data class AdjustingSliderFive(val value : Float) : UiEvents()
}