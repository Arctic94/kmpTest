package com.example.myapplication.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun MyState(){
    var number by rememberSaveable() { mutableIntStateOf(0) }
    Column(Modifier.safeContentPadding()) {
        Contador(number)  {number += 1}
        Contador2(number,onClick = {number += 2})
    }
}
@Composable
fun Contador(number: Int, onClick:()-> Unit){
    Text("pulsame ${number}", Modifier.clickable{onClick()})

}
@Composable
fun Contador2(number: Int, onClick:()-> Unit){
    Text("pulsame ${number}", Modifier.clickable{onClick()})

}
