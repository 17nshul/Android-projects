package com.example.test

import android.graphics.Color
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import com.example.test.composables.LoginPage1
import com.example.test.composables.OnBoardingPage1
import com.example.test.ui.ComposeLooksTutorialTheme
import com.example.test.composables.OnBoardingPage1
import com.example.test.ui.ComposeLooksTutorialTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val windows = this.window
        windows.statusBarColor = Color.WHITE

        setContent {
            ComposeLooksTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    OnBoardingPage1()
                }
            }
        }
    }
}

