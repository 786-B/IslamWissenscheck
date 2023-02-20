package com.ykp.islamwissenscheck.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ykp.islamwissenscheck.component.NoConnectionPage
import com.ykp.islamwissenscheck.component.Question
import com.ykp.islamwissenscheck.network.checkNetworkState

@Composable
fun BilmeceHome(viewModel: QuestionsViewModel = hiltViewModel()) {

    var networkAvailable = checkNetworkState()

    if (networkAvailable) {
        Question(viewModel)

    } else {
        NoConnectionPage()

    }
}