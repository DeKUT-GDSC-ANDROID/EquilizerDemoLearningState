package com.example.equilizerdesign

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.equilizerdesign.utils.VerticalSlider


@Composable
fun EqualizerUi() {
    val viewModel: EqualizerViewModel = viewModel()
//    val state = viewModel.uiState
    val state = viewModel.uiState.collectAsState().value
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()){
        EqualizerCustom(uiState = state, viewModel = viewModel)
    }
}

@Composable
fun EqualizerCustom(uiState: UiState, viewModel: EqualizerViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        VerticalSlider(
            value = uiState.sliderOneValue,
            onValueChange = { viewModel.onEvent(UiEvents.AdjustingSliderOne(it))}
        )
        VerticalSlider(
            value = uiState.sliderTwoValue,
            onValueChange = {viewModel.onEvent(UiEvents.AdjustingSliderTwo(it))}
        )
        VerticalSlider(
            value = uiState.sliderThreeValue,
            onValueChange = {viewModel.onEvent(UiEvents.AdjustingSliderThree(it))}
        )
        VerticalSlider(
            value = uiState.sliderFourValue,
            onValueChange = {viewModel.onEvent(UiEvents.AdjustingSliderFour(it))}
        )
        VerticalSlider(
            value = uiState.sliderFiveValue,
            onValueChange = {viewModel.onEvent(UiEvents.AdjustingSliderFive(it))}
        )
    }
}


@Preview(showSystemUi = true)
@Composable
private fun EqualizerUiPrev() {
    EqualizerUi()
}