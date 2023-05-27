package com.example.test.composables
import androidx.compose.foundation.Image

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.test.R
import com.example.test.ui.orangish
import com.example.test.ui.purplish
import com.example.test.ui.shapes

import androidx.compose.ui.text.SpanStyle

import java.util.*


@Preview(showBackground = true)
@Composable
fun LoginPage1() {

    Box() {
        BgCard()
        MainCard()

    }

}

@Composable
fun BgCard() {
    val signupText = annotatedString {
        append("Don't have an account? ")
        withStyle(SpanStyle(color = orangish)) {
            append("Sign up here!")
        }
    }
    Surface(color = purplish, modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.Bottom, horizontalGravity = Alignment.CenterHorizontally, modifier = Modifier.offset(y = (-30).dp)
        ) {
            Row() {
                Image(painter = painterResource(R.drawable.ic_fb))
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Image(painter = painterResource(id = R.drawable.ic_google))
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Image(painter = painterResource(id = R.drawable.ic_twitter))

            }
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Text(text = signupText, color = Color.White)
        }
    }
}


@Composable
fun MainCard() {
    val emailState = remember { mutableStateOf(TextFieldValue("mtechviral@gmail.com")) }
    val passState = remember { mutableStateOf(TextFieldValue("")) }
    Surface(color = Color.White, modifier = Modifier.height(600.dp).fillMaxWidth(),
            shape = RoundedCornerShape(60.dp).copy(topLeft = ZeroCornerSize, topRight = ZeroCornerSize)) {
        Column(modifier = Modifier.padding(16.dp), horizontalGravity = Alignment.CenterHorizontally
        ) {

            val modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
            Image(asset = painterResource(id = R.drawable.ic_vaccum))
            Spacer(modifier = Modifier.padding(16.dp))
            OutlinedTextField(value = emailState.value, onValueChange = {
                emailState.value = it
            }, {
                Text(text = "Email address")
            }, leadingIcon = { Icon(Icons.Filled.Email) }, modifier = modifier)

            Spacer(modifier = Modifier.padding(6.dp))

            OutlinedTextField(value = passState.value, onValueChange = {
                passState.value = it
            }, {
                Text(text = "Password")

            }, leadingIcon = { Icon(Icons.Filled.Lock) }, modifier = modifier, keyboardType = KeyboardType.Password)

            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            CompositionLocalProvider(ContentAlpha = EmphasisAmbient.current.disabled) {
                Text(text = "Forgot password?", textAlign = TextAlign.End, modifier = modifier)
            }
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            Button(onClick = {}, backgroundColor = orangish, shape = shapes.medium,
                    contentColor = Color.White, modifier = modifier, contentPadding = InnerPadding(16.dp)
            ) {
                Text(text = "Log In")
            }
        }
    }
}