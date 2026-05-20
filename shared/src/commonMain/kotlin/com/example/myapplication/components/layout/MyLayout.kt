package com.example.myapplication.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyLayout(){
    Column(Modifier.safeContentPadding()) {
        Box(Modifier.weight(1f).fillMaxWidth().background(Color.LightGray), Alignment.Center){Text("hola")}
       Row(Modifier.weight(1f).fillMaxWidth().background(Color.Green), ) {
           Box(Modifier.weight(1f).background(Color.Blue).fillMaxHeight(), Alignment.Center) {
               Text(
                   "mundo"
               )
           }
           Spacer(Modifier.width(10.dp))
           Box(
               Modifier.weight(1f).background(Color.Yellow).fillMaxHeight(),
               Alignment.Center
           ) { Text("mundo2") }
       }
        Box(Modifier.weight(1f).fillMaxWidth().background(Color.Red), Alignment.BottomCenter){Text("jaja")}
    }
}