package com.example.myapplication.components.layout

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyRow(){
    Row(modifier = Modifier.horizontalScroll(rememberScrollState()).padding(20.dp)) {
        Text("hola 1")
        Text("hola 2")
        Text("hola 3")
        Text("hola 4")
        Text("hola 1")
        Text("hola 2")
        Text("hola 3")
        Text("hola 4")
        Text("hola 1")
        Text("hola 3")
        Text("hola 4")
        Text("hola 1")
        Text("hola 3")
        Text("hola 4")
        Text("hola 1")
    }
}