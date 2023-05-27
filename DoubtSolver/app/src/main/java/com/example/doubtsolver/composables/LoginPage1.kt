package com.example.doubtsolver.composables

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.doubtsolver.ui.theme.purplish
import java.util.*


@Preview(showBackground = true)
@Composable
fun LoginPage1(){
    Stack{
        Surface(color = purplish,modifier = Modifier.fillMaxSize()) {
            
        }

        Surface(color = Color.White,modifier = Modifier.prefferedHeight(600.dp)) {

        }

    }
}
@Composable
fun Stack(function: Any) {
    TODO("Not yet implemented")
}

