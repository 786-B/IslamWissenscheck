package com.ykp.islamwissenscheck.component

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ykp.islamwissenscheck.R


@Composable
fun NoConnectionPage() {

    val activity = (LocalLifecycleOwner.current as ComponentActivity)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .fillMaxSize()
            .padding(9.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.signal_disconnected),
            "disconnected",
            modifier = Modifier
                .size(90.dp),
        )
        Text(text = "No Connection", fontSize = 30.sp, textAlign = TextAlign.Center)
        ButtonBehavior(
            buttonText = "Exit", Modifier
                .padding(top = 25.dp), Color.LightGray.copy(0.3f),
            Icons.Filled.Close
        ) {
            activity.finish()
        }
    }

}