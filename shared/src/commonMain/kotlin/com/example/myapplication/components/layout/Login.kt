package com.example.myapplication.components.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun LoginPage(){
    var user:String by remember { mutableStateOf("") }
    var pass:String by remember { mutableStateOf("") }
    val userState = rememberTextFieldState()
    val passState = rememberTextFieldState()
    Column(
        Modifier.safeContentPadding()
    ) {
        UserInput(user){ user = it}
        PassInput(pass){ pass = it}

        UserInputState(userState)
        PassInputState(passState)

    }
}
@Composable
fun UserInput(user: String, onUserChange:(String)->Unit){
    TextField(user, onValueChange = {onUserChange(it)})
}
@Composable
fun PassInput(pass: String, onUserChange:(String)->Unit){
    TextField(
        value = pass,
        onValueChange = {onUserChange(it)},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        visualTransformation = PasswordVisualTransformation()
    )
}


@Composable
fun UserInputState(state: TextFieldState){
    OutlinedTextField(state)
}
@Composable
fun PassInputState(state:TextFieldState){
    SecureTextField(state)
}


