package com.example.test.composables

import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test.R
import com.example.test.ui.orangish
import com.example.test.ui.purplish
import com.google.android.filament.Box
import java.util.*


@Preview(showBackground = true)
@Composable
fun OnBoardingPage1(){
    Box(modifier = ){
        BgCard2()
        MainCard2()
    }
}

@Composable
fun BgCard2() {
    val signupText = annotatedString {
        append("Don't have an account? ")
        withStyle(SpanStyle(color = orangish)) {
            append("Sign up here!")
        }
    }
    Surface(color = purplish, modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.Bottom, horizontalGravity = Alignment.CenterHorizontally, modifier = Modifier.offset(y = (-30).dp)
        ) {
            Row {
                Box(backgroundColor = Color.Gray,modifier = Modifier.size(10.dp),shape = CircleShape)
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Box(backgroundColor = Color.White,modifier = Modifier.size(12.dp),shape = CircleShape)
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Box(backgroundColor = Color.Gray,modifier = Modifier.size(10.dp),shape = CircleShape)

            }
            Row(horizontalArrangement = Arrangement.SpaceBetween,modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
                TextButton(onClick = {}) {
                    Text(text = "Skip", color = Color.White)
                }
                Row(verticalArrangement = Arrangement.Center ) {
                    TextButton(onClick = {}) {
                        Text(text = "Next", color = Color.White)
                        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                        Image(asset = vectorResource(id = R.drawable.ic_next))
                    }
                }
            }
        }
    }
}


@Composable
fun MainCard2() {
    Surface(color = Color.White, modifier = Modifier.height(600.dp).fillMaxWidth(),
            shape = RoundedCornerShape(60.dp).copy(topLeft = ZeroCornerSize, topRight = ZeroCornerSize)) {
        Column(modifier = Modifier.padding(16.dp), horizontalGravity = Alignment.CenterHorizontally
        ) {
            Image(asset = vectorResource(id = R.drawable.ic_cleaning))
            Spacer(modifier = Modifier.padding(32.dp))
            ProvideEmphasis(emphasis = EmphasisAmbient.current.high) {
                Text(text = "Cleaning on Demand",style = MaterialTheme.typography.h6)
            }

            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            ProvideEmphasis(emphasis = EmphasisAmbient.current.medium) {
                Text(text = "Book an appointment in less than 60 seconds and get on the schedule as early as tomorrow.",
                        style = MaterialTheme.typography.caption, textAlign = TextAlign.Center)


            }

        }
    }
}