package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.components.layout.LoginPage

import com.example.myapplication.components.layout.MyColumn
import com.example.myapplication.components.layout.MyLayout
import com.example.myapplication.components.layout.MyRow
import com.example.myapplication.components.layout.ReactiveLoginPage
import com.example.myapplication.state.MyState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            ReactiveLoginPage()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}